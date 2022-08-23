package collections.lists;

import collections.nodes.DoublyLinkedNode;
import collections.nodes.LinkedNode;

import java.util.Collection;
import java.util.Iterator;

public final class MyLinkedList<E> implements MyList<E>{

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private int elementsCount;

    public MyLinkedList() {
        clear();
    }

    public MyLinkedList(Collection<E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    private boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public void add(E value) {
        if (isEmpty()) {
            DoublyLinkedNode<E> doublyLinkedNode = new DoublyLinkedNode<>(value);
            head = tail = doublyLinkedNode;
        } else {
            DoublyLinkedNode<E> doublyLinkedNode = new DoublyLinkedNode<>(value, null, tail);
            tail.setNext(doublyLinkedNode);
            tail = doublyLinkedNode;
        }

        elementsCount++;
    }

    private LinkedNode<E> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= elementsCount) {
            throw new IndexOutOfBoundsException();
        }

        if (index <= elementsCount / 2) {
            LinkedNode<E> tempNode = head;
            for (int i = 0; i < index; ++i) {
                tempNode = tempNode.getNext();
            }

            return tempNode;
        }

        LinkedNode<E> tempNode = tail;
        for (int i = 0; i < elementsCount - 1 - index; ++i) {
            tempNode = ((DoublyLinkedNode<E>) tempNode).getPrev();
        }

        return tempNode;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        DoublyLinkedNode<E> nodeToDelete = (DoublyLinkedNode<E>) getNode(index);

        if (nodeToDelete == head) {
            head = nodeToDelete.getNext();
        }

        if (nodeToDelete == tail) {
            tail = nodeToDelete.getPrev();
        }

        if (head != null && tail != null) {

            if(nodeToDelete.getNext() != null) {
                DoublyLinkedNode<E> nextNode = (DoublyLinkedNode<E>) nodeToDelete.getNext();
                nextNode.setPrev(nodeToDelete.getPrev());
            }

            if(nodeToDelete.getPrev() != null) {
                DoublyLinkedNode<E> prevNode = (DoublyLinkedNode<E>) nodeToDelete.getPrev();
                prevNode.setNext(nodeToDelete.getNext());
            }
        }

        elementsCount--;
    }

    @Override
    public void clear() {
        while(!isEmpty()) {
            remove(0);
        }
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < elementsCount;
        }

        @Override
        public E next() {
            if (hasNext()) {
                return get(cursor++);
            }

            return null;
        }
    }
}
