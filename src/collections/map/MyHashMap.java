package collections.map;

import collections.nodes.LinkedNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int START_CAPACITY = 16;
    private static final double loadFactor = 0.75;
    private EntryNode<K, V>[] array;
    private int elementsCount;
    private int threshold;

    public MyHashMap() {
        clear();
    }

    public MyHashMap(Map<K, V> map) {
        clear();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    private void putPair(K key, V value) {
        int hash = (key == null ? 0 : key.hashCode());
        int index = hash % array.length;

        if (array[index] == null) {
            array[index] = new EntryNode<K, V>(key, value);
            elementsCount++;
            return;
        }

        for (EntryNode<K, V> iNode = array[index]; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
            if (hash == iNode.getHash()) {
                iNode.setValue(value);
                return;
            }

            if (iNode.getNext() == null) {
                iNode.setNext(new EntryNode<>(key, value));
                elementsCount++;
            }
        }
    }

    private void resize() {
        Set<EntryNode<K, V>> nodeSet = getNodeSet();
        EntryNode<K, V>[] newArray = (EntryNode<K,V>[]) new EntryNode[array.length * 2];
        Arrays.fill(newArray, null);
        this.array = newArray;
        elementsCount = 0;
        threshold = (int) (2 * array.length * loadFactor);

        for (EntryNode<K, V> node : nodeSet) {
            putPair(node.getKey(), node.getValue());
        }
    }

    @Override
    public void put(K key, V value) {

        putPair(key, value);
        if (elementsCount >= threshold) {
            resize();
        }
    }

    @Override
    public void remove(K key) {
        int hash = (key == null ? 0 : key.hashCode());
        int index = hash % array.length;

        if (array[index] == null) {
            return;
        }

        for (EntryNode<K, V> node = array[index], prevNode = null; node != null; prevNode = node, node = (EntryNode<K, V>) node.getNext()) {
            if (hash == node.getHash()) {
                if (node == array[index]) {
                    array[index] = (EntryNode<K, V>) node.getNext();
                }

                if (prevNode != null) {
                    prevNode.setNext(node.getNext());
                }

                elementsCount--;
                return;
            }
        }
    }

    @Override
    public void clear() {
        array = (EntryNode<K, V>[]) new EntryNode[START_CAPACITY];
        Arrays.fill(array, null);
        elementsCount = 0;
        threshold = (int) (START_CAPACITY * loadFactor);
    }

    @Override
    public int size() {
        return elementsCount;
    }

    public Set<K> getKeySet() {
        Set<K> keySet = new HashSet<>();
        for (EntryNode<K, V> node : array) {
            for (EntryNode<K, V> iNode = node; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
                keySet.add(iNode.getKey());
            }
        }
        return keySet;
    }

    public Set<V> getValueSet() {
        Set<V> valueSet = new HashSet<>();
        for (EntryNode<K, V> node : array) {
            for (EntryNode<K, V> iNode = node; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
                valueSet.add(iNode.getValue());
            }
        }
        return valueSet;
    }

    public Set<EntryNode<K, V>> getNodeSet() {
        Set<EntryNode<K, V>> nodeSet = new HashSet<>();
        for (EntryNode<K, V> node : array) {
            for (EntryNode<K, V> iNode = node; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
                nodeSet.add(new EntryNode<>(iNode.getKey(), iNode.getValue()));
            }
        }
        return nodeSet;
    }

    @Override
    public V get(K key) {

        int hash = (key == null ? 0 : key.hashCode());
        int index = hash % array.length;

        if (array[index] == null) {
            return null;
        }

        for (EntryNode<K, V> iNode = array[index]; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
            if (hash == iNode.getHash()) {
                return iNode.getValue();
            }
        }

        return null;
    }

    public static class EntryNode<K, V> extends LinkedNode<V> {

        private final K key;
        private final int hash;

        public EntryNode(K key, V value) {
            super(value);
            this.key = key;
            this.hash = key == null ? 0 : key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public int getHash() {
            return hash;
        }
    }
}

