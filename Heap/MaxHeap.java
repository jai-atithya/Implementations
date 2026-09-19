import java.util.*;
public class MaxHeap<T extends Comparable<T>> implements Heap<T>{
    List<T> heap;
    public MaxHeap(){
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
        T max=heap.get(0);
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        heapifyDown();
        return max;
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
            if (heap.get(parent).compareTo(heap.get(child)) >= 0) {
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
            int largest = parent;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(largest)) > 0) {
                largest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
                largest = rightChild;
            }
            if (largest == parent) {
                break;
            }
            swap(parent, largest);
            parent = largest;
        }
    }
    private void swap(int a, int b){
        T temp=heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}