package collections.map;

import collections.MyCollectionTester;

import java.util.HashMap;
import java.util.Map;

public class MyHashMapTester implements MyCollectionTester {

    @Override
    public void test() {

        MyMap<Integer, String> map;
        System.out.println("Testing MyHashMap...");
        Map<Integer, String> startMap = new HashMap<>();
        startMap.put(1, "One");
        startMap.put(10, "Ten");
        startMap.put(100, "One hundred");
        System.out.println("Testing constructor (1/2) | Initializing map with " + startMap);
        map = new MyHashMap<>(startMap);


        System.out.println("Getting keySet: " + map.getKeySet());
        System.out.println("Getting valueSet: " + map.getValueSet());
        System.out.println("Getting nodeSet: " + map.getNodeSet());
        System.out.println("Getting size: " + map.size());

        map.clear();
        System.out.println("Clearing map:" + map.getNodeSet());

        System.out.println("Testing constructor (2/2) | Initializing map without arguments");
        map = new MyHashMap<>();

        System.out.println("Putting new pair [0, Zero]");
        map.put(0, "Zero");
        System.out.println(map);

        System.out.println("Collision test: putting new pair [16, Sixteen]");
        map.put(16, "Sixteen");
        System.out.println(map);

        System.out.println("Getting value by key 16: " + (map.get(16) == null ? "null" : map.get(16)));
        System.out.println("Getting value by unrepresented key 32: " + (map.get(32) == null ? "null" : map.get(32)));

        System.out.println(map.getNodeSet());

        System.out.println("Removing pair by key 0:");
        map.remove(0);
        System.out.println(map.getNodeSet());

        System.out.println("Removing pair by unrepresented key 32:");
        map.remove(32);
        System.out.println(map.getNodeSet());

        System.out.println("MyHashMap testing complete.\n");
    }
}
