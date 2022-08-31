package collections.queue;

import collections.MyCollectionTester;

import java.util.List;

public class MyQueueTester implements MyCollectionTester {

    @Override
    public void test() {

        MyQueue<Integer> queue;
        System.out.println("Testing MyQueue...");
        System.out.println("Testing constructor (1/2) | Initializing queue with given collection of {1, 3, 5, 7}");
        queue = new MyQueue<>(List.of(1, 3, 5, 7));
        System.out.println(queue);

        System.out.println("Clearing the queue...");
        queue.clear();
        System.out.println(queue);

        System.out.println("Testing constructor (2/2) | Initializing queue without arguments");
        queue = new MyQueue<>();
        System.out.println(queue);

        System.out.println("Filling queue with numbers 0 ... 9:");
        for (int i = 0; i < 10; ++i) {
            queue.add(i);
        }
        System.out.println(queue);

        System.out.println("Peeking queue: " + queue.peek());
        System.out.println("Polling queue: " + queue.poll());
        System.out.println(queue);

        System.out.println("Removing value 5 from queue: " + queue.remove(5));
        System.out.println(queue);

        System.out.println("Removing unrepresented value 50 from queue: " + queue.remove(50));
        System.out.println(queue);

        System.out.println("Getting size of queue: " + queue.size());
        System.out.println("MyQueue testing complete.\n");
    }
}
