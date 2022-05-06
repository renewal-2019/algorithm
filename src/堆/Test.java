package 堆;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(3);
        heap.insert(5);
        heap.insert(55);
        heap.insert(8);
        heap.insert(7);
        heap.insert(2);
        System.out.println(Arrays.toString(heap.getHeap()));
    }
}
