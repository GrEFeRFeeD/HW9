package collections.queue;

public interface MyFIFOQueue<E> {
    void add(E value);
    void remove();
    void clear();
    int size();
    E peek();
    E poll();
}