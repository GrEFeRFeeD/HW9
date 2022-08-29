package collections.lists;

import collections.MyCollectionTester;

import java.util.List;

public class MyArrayListTester implements MyCollectionTester {

    @Override
    public void test() {
        MyList<Integer> list;

        System.out.println("Testing MyArrayList...");
        System.out.println("Testing constructor (1/2) | Initializing list with given collection of {1, 3, 5, 7}");
        list = new MyArrayList<>(List.of(1, 3, 5, 7));
        System.out.println(list);

        System.out.println("Clearing the list...");
        list.clear();
        System.out.println(list);

        System.out.println("Testing constructor (2/2) | Initializing list without arguments");
        list = new MyArrayList<>();
        System.out.println(list);

        System.out.println("Filling list with numbers 0 ... 9:");
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        System.out.println(list);

        System.out.println("Getting and removing certain elements:");
        System.out.println("Removing 9th element (" + list.get(9) + ")");
        list.remove(9);
        System.out.println(list);
        System.out.println("Removing 0th element (" + list.get(0) + ")");
        list.remove(0);
        System.out.println(list);
        System.out.println("Removing 6th element (" + list.get(6) + ")");
        list.remove(6);
        System.out.println(list);
        System.out.println("Removing 2th element (" + list.get(2) + ")");
        list.remove(2);
        System.out.println(list);

        try {
            System.out.println("Getting 1000th element: ");
            System.out.println("Element: " + list.get(1000));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Catched IndexOutOfBoundsException at index 1000");
        }

        try {
            System.out.println("Removing -1000th element: ");
            System.out.println("Element: " + list.get(-1000));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Catched IndexOutOfBoundsException at index -1000");
        }

        System.out.println("Getting size of list: " + list.size());
        System.out.println("MyArrayList testing complete.\n");
    }
}
