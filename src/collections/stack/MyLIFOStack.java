package collections.stack;

public interface MyLIFOStack<E> {
    void push(E value);
    void remove();
    void clear();
    int size();
    E peek();
    E pop();
}
