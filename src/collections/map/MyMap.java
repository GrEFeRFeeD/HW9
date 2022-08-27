package collections.map;

import collections.map.exceptions.IncorrectArrayInitializationSizeException;

import java.util.Set;

public interface MyMap<K, V> {
    void put(K key, V value);
    void remove(K key);
    void clear() throws IncorrectArrayInitializationSizeException;
    int size();
    V get(K key);
    Set<K> getKeySet();
    Set<V> getValueSet();
    Set<MyHashMap.EntryNode<K, V>> getNodeSet();
}
