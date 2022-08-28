import collections.MyCollectionTester;
import collections.lists.MyListsTester;
import collections.map.MyHashMapTester;
import collections.queue.MyQueueTester;
import collections.stack.MyStackTester;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<MyCollectionTester> testerList = new ArrayList<>();
        testerList.add(new MyListsTester());
        testerList.add(new MyQueueTester());
        testerList.add(new MyStackTester());
        testerList.add(new MyHashMapTester());

        for (MyCollectionTester tester : testerList) {
            tester.test();
        }
    }
}
