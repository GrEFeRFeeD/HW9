package collections.queue;

import collections.nodes.LinkedNode;

import java.util.Collection;

public class MyQueue<E> implements MyFIFOQueue<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private int elementsCount;

    public MyQueue() {
        head = tail = null;
        elementsCount = 0;
    }

    public MyQueue(Collection<E> collection) {
        this();
        for (E value : collection) {
            add(value);
        }
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public void add(E value) {
        LinkedNode<E> newNode = new LinkedNode<>(value, null);

        if (head == null) {
            head = newNode;
        }

        if (tail != null) {
            tail.setNext(newNode);
        }

        tail = newNode;
        elementsCount++;
    }

    @Override
    public void remove() {
        poll();
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            poll();
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
    public E poll() {

        if (head == null && tail == null) {
            return null;
        }

        LinkedNode<E> nodeToDelete = head;
        head = nodeToDelete.getNext();

        if (head == null) {
            tail = null;
        }

        elementsCount--;

        return nodeToDelete.getValue();
    }
}
