public interface Stack<T> {

    int getSize();
    boolean isEmpty();
    void push(T e);
    T pop();
    T peek();

}
