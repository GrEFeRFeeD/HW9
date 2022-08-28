package collections.map;

import collections.MyCollectionTester;
import collections.map.exceptions.IncorrectArrayInitializationSizeException;

public class MyHashMapTester implements MyCollectionTester {

    /*
    void put(K key, V value);
    void remove(K key);
    void clear() throws IncorrectArrayInitializationSizeException;
    int size();
    V get(K key);
    Set<K> getKeySet();
    Set<V> getValueSet();
    Set<MyHashMap.EntryNode<K, V>> getNodeSet();
     */

    @Override
    public void test() {

        try {
            MyMap<Integer, String> map = new MyHashMap<>();
            map.put(0, "odin");
            map.put(1, "dva");
            map.put(2, "tri");
            map.put(5, "4otyre");
            map.put(16, "pyat");

            System.out.println(map);
            System.out.println(map.getNodeSet());

        } catch (IncorrectArrayInitializationSizeException e) {
            System.out.println("Catched IncorrectArrayInitializationSizeException: " + e.getMessage());
        }


    }
}
