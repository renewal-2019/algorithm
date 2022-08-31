package 排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,2,3,6,9,7,55,33,44};
        quickSortA(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSortA(int[] array) {
        quickSortX(array, 0, array.length - 1);
    }

    public static void quickSortX(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(array, left, right);
        quickSortX(array, left, partition - 1);
        quickSortX(array, partition + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] < array[right]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[right];
        array[right] = array[i];
        array[i] = temp;
        return i;
    }
}
