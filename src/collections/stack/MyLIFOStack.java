package collections.stack;

public interface MyLIFOStack<E> {
    void push(E value);
    boolean remove(E value);
    void clear();
    int size();
    E peek();
    E pop();
}
