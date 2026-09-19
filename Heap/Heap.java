public interface Heap<T>{
    public abstract void insert(T element);
    public abstract T peek();
    public abstract T pop();
    public abstract boolean isEmpty();
}
