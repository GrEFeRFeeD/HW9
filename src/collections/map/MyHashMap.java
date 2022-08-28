package collections.map;

import collections.map.exceptions.IncorrectArrayInitializationSizeException;
import collections.nodes.LinkedNode;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int START_CAPACITY = 16;
    private static final double loadFactor = 0.75;
    private EntryNode<K, V>[] array;
    private int elementsCount;
    private int threshold;

    public MyHashMap() throws IncorrectArrayInitializationSizeException{
        clear();
    }

    public MyHashMap(Map<K, V> map) throws IncorrectArrayInitializationSizeException {
        clear();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public static<K> int getHash(K key) {
        return (key == null ? 0 : key.hashCode());
    }

    @Override
    public void put(K key, V value) {

        putPair(key, value);
        if (elementsCount >= threshold) {
            resize();
        }
    }

    private void putPair(K key, V value) {
        int hash = getHash(key);
        int index = hash % array.length;

        if (array[index] == null) {
            array[index] = new EntryNode<>(key, value);
            elementsCount++;
            return;
        }

        for (EntryNode<K, V> iNode = array[index]; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
            if (iNode.equals(new EntryNode<>(key, value))) {
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
    public void remove(K key) {
        int hash = getHash(key);
        int index = hash % array.length;

        if (array[index] == null) {
            return;
        }

        for (EntryNode<K, V> node = array[index], prevNode = null; node != null; prevNode = node, node = (EntryNode<K, V>) node.getNext()) {
            if (node.keyEquals(key)) {
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
    public void clear() throws IncorrectArrayInitializationSizeException {
        array = (EntryNode<K, V>[]) new EntryNode[START_CAPACITY];
        if (array.length <= 0) {
            throw new IncorrectArrayInitializationSizeException();
        }
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
    public V get(K key){

        int hash = getHash(key);
        int index = hash % array.length;

        if (array[index] == null) {
            return null;
        }

        for (EntryNode<K, V> iNode = array[index]; iNode != null; iNode = (EntryNode<K, V>) iNode.getNext()) {
            if (iNode.keyEquals(key)) {
                return iNode.getValue();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyHashMap: { \n");
        for (int i = 0; i < array.length; ++i) {
            sb.append("\t ").append(i).append(" : {");

            for(EntryNode<K, V> node = array[i]; node != null; node = (EntryNode<K, V>) node.getNext()) {
                sb.append(" [").append(node.getKey()).append(" = ").append(node.getValue()).append("], ");
            }

            if (array[i] != null) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append(" },\n");
        }
        sb.delete(sb.length() - 2, sb.length()).append("\n}");
        return sb.toString();
    }

    public static class EntryNode<K, V> extends LinkedNode<V> {

        private final K key;
        private final int hash;

        public EntryNode(K key, V value) {
            super(value);
            this.key = key;
            this.hash = MyHashMap.getHash(key);
        }

        public K getKey() {
            return key;
        }

        public int getHash() {
            return hash;
        }

        public boolean keyEquals(K key) {
            return MyHashMap.getHash(key) == getHash()
                    && (key == null ?
                    getKey() == null : key.equals(getKey()) );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EntryNode<K, V> e2 = (EntryNode<K, V>) o;
            return  (this.getKey()==null ?
                    e2.getKey()==null : this.getKey().equals(e2.getKey()))  &&
                    (this.getValue()==null ?
                            e2.getValue()==null : this.getValue().equals(e2.getValue()));
        }

        @Override
        public String toString() {
            return "EntryNode{" +
                    "key=" + key +
                    ", hash=" + hash +
                    ", value=" + value +
                    '}';
        }
    }
}

