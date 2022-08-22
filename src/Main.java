import collections.lists.MyArrayList;
import collections.lists.MyList;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        System.out.println(myList);
        for (int i = 0; i < 100; ++i) {
            myList.add(i);
            System.out.println(myList);
        }
        for(int i = 99; i >= 0; --i) {
            try {
                myList.remove(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Catched IndexOutOfBoundsException at i = " + i);
            }

            System.out.println(myList);
        }

        for (int i = 1; i <= 10; ++i) {
            myList.add(i);
        }
        System.out.println(myList);

        try {
            myList.remove(0);
            myList.remove(2);
            myList.remove(4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Catched IndexOutOfBoundsException");
        }
        System.out.println(myList);
    }
}
