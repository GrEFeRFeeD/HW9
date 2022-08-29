package collections.stack;

import collections.MyCollectionTester;

import java.util.List;

public class MyStackTester implements MyCollectionTester {

    @Override
    public void test() {
        
        MyStack<Integer> stack;
        System.out.println("Testing MyStack...");
        System.out.println("Testing constructor (1/2) | Initializing stack with given collection of {1, 3, 5, 7}");
        stack = new MyStack<>(List.of(1, 3, 5, 7));
        System.out.println(stack);

        System.out.println("Clearing the stack...");
        stack.clear();
        System.out.println(stack);

        System.out.println("Testing constructor (2/2) | Initializing stack without arguments");
        stack = new MyStack<>();
        System.out.println(stack);

        System.out.println("Filling stack with numbers 0 ... 9:");
        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println("Peeking stack: " + stack.peek());
        System.out.println("Popping stack: " + stack.pop());
        System.out.println(stack);

        System.out.println("Removing value 5 from stack: " + stack.remove(5));
        System.out.println(stack);

        System.out.println("Removing unrepresented value 50 from stack: " + stack.remove(50));
        System.out.println(stack);

        System.out.println("Getting size of stack: " + stack.size());
        System.out.println("MyStack testing complete.\n");
    }
}
