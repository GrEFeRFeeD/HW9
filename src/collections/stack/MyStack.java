package collections.stack;

import collections.nodes.LinkedNode;

import java.util.Collection;

public class MyStack<E> implements MyLIFOStack<E> {

    private LinkedNode<E> head;
    private int elementsCount;

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    public MyStack() {
        head = null;
        elementsCount = 0;
    }

    public MyStack(Collection<E> collection) {
        this();
        for (E value : collection) {
            push(value);
        }
    }

    @Override
    public void push(E value) {
        LinkedNode<E> newNode = new LinkedNode<>(value, head);
        head = newNode;
        elementsCount++;
    }

    @Override
    public void remove() {
        pop();
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public E peek() {
        return (head == null)?(null):(head.getValue());
    }

    @Override
    public E pop() {

        if (head == null) {
            return null;
        }

        LinkedNode<E> nodeToDelete = head;
        head = head.getNext();
        elementsCount--;

        return nodeToDelete.getValue();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{ ");
        for (LinkedNode<E> i = head; i != null; i = i.getNext()) {
            sb.append(i.getValue()).append(", ");
        }
        sb.append("} size = ").append(elementsCount);
        return sb.toString();
    }
}
