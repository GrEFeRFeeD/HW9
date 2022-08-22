package collections.lists;

import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

    private E[] array;
    private int headIndex;

    public MyArrayList() {
        clear();
    }

    public MyArrayList(Collection<E> collection) {
        array = (E[]) new Object[collection.size() * 3 / 2];
        for (E element : collection) {
            add(element);
        }
    }

    private void expandArray() {
        if (headIndex * 3 / 2 >= array.length) {
            E[] newArray = (E[]) new Object[array.length * 3 / 2];
            System.arraycopy(array, 0, newArray, 0, size());
            array = newArray;
        }
    }

    private void shrinkArray() {
        if (headIndex * 3 / 2 < array.length * 2 / 3 && array.length * 2 / 3 + 1 >= 15) {
            E[] newArray = (E[]) new Object[array.length * 2 / 3 + 1];
            System.arraycopy(array, 0, newArray, 0, size());
            array = newArray;
        }
    }

    @Override
    public void add(E value) {
        array[headIndex++] = value;
        expandArray();
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > headIndex) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(array, index + 1, array, index, headIndex - index);
        headIndex--;
        shrinkArray();
    }

    @Override
    public void clear() {
        array = (E[]) new Object[15];
        headIndex = 0;
    }

    @Override
    public int size() {
        return headIndex + 1;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= headIndex) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < headIndex;
        }

        @Override
        public E next() {
            if (hasNext()) {
                return array[cursor];
            }

            return null;
        }
    }
}
