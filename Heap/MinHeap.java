import java.util.*;
public class MinHeap<T extends Comparable<T>> implements Heap<T>{
    List<T> heap;
    public MinHeap(){
        heap = new ArrayList<T>();
    }
    public void insert(T element){
        heap.add(element);
        heapifyUp();
        return;
    }
    public T peek(){
        if(isEmpty()) return null;
        return heap.get(0);
    }
    public T pop(){
        if(isEmpty()) return null;
        T min=heap.get(0);
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        heapifyDown();
        return min;
    }
    public boolean isEmpty(){
        if(heap.size()==0) return true;
        return false;   
    }
    private void heapifyUp(){
        if(isEmpty()) return;
        int child = heap.size() - 1;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (heap.get(parent).compareTo(heap.get(child)) <= 0) {
                break;
            }   
            swap(child, parent);
            child = parent;
        }
    }
    private void heapifyDown(){
        if(isEmpty()) return;
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            int smallest = parent;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest == parent) {
                break;
            }
            swap(parent, smallest);
            parent = smallest;
        }
    }
    private void swap(int a, int b){
        T temp=heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}