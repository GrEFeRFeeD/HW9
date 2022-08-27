package collections.queue;

import collections.nodes.LinkedNode;

import java.util.Collection;

public final class MyQueue<E> implements MyFIFOQueue<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private int elementsCount;

    public MyQueue() {
        clear();
    }

    public MyQueue(Collection<E> collection) {
        clear();
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
    public boolean remove(E value) {
        for (LinkedNode<E> node = head, prev = null; node != null; prev = node, node = node.getNext()) {
            if (node.getValue().equals(value)) {
                if (node == head) {
                    head = node.getNext();
                }

                if (node == tail) {
                    tail = prev;
                }

                if (prev != null) {
                    prev.setNext(node.getNext());
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        elementsCount = 0;
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
