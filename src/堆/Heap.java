package 堆;

public class Heap {
    // 从下标1开始存储
    private int[] heap;

    // 堆的容量
    private int n;

    // 堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        heap = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }

        ++count;
        // 暂时放在队尾
        heap[count] = data;

        int i = count;
        while (i / 2 > 0 && heap[i] > heap[i / 2]) {
            swap(heap, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] heap, int indexA, int indexB) {
        int a = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = a;
    }

    public int[] getHeap() {
        return heap;
    }

    public int getN() {
        return n;
    }

    public int getCount() {
        return count;
    }
}
