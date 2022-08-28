package collections.stack;

import collections.nodes.LinkedNode;

import java.util.Collection;

public final class MyStack<E> implements MyLIFOStack<E> {

    private LinkedNode<E> head;
    private int elementsCount;

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    public MyStack() {
        clear();
    }

    public MyStack(Collection<E> collection) {
        clear();
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
    public boolean remove(E value) {
        LinkedNode<E> node = head;
        LinkedNode<E> prev = null;

        while (node != null) {

            if (node.getValue().equals(value)) {
                if (node == head) {
                    head = node.getNext();
                }

                if (prev != null) {
                    prev.setNext(node.getNext());
                }

                return true;
            }

            prev = node;
            node = node.getNext();
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
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
    public E pop() {

        if (head == null) {
            return null;
        }

        LinkedNode<E> nodeToDelete = head;
        head = head.getNext();
        elementsCount--;

        return nodeToDelete.getValue();
    }
}
