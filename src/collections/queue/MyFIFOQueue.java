package collections.queue;

public interface MyFIFOQueue<E> {
    void add(E value);
    boolean remove(E value);
    void clear();
    int size();
    E peek();
    E poll();
}