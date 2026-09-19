import java.util.*;
class Main{
    public static void main(String[] args){
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        System.out.println("Min Heap:");
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.pop());
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        System.out.println("Max Heap:");
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.pop());
        }
    }
}