package 排序;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 3, 6, 9, 7, 55, 33, 44};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        split(array, 0, array.length - 1);
    }

    public static void split(int[] array, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        split(array, left, mid);
        split(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1; // 注意此处为mid + 1（因为mid可能会和left相等）
        int tempIndex = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[tempIndex++] = array[i++];
            } else {
                temp[tempIndex++] = array[j++];
            }
        }
        int start = i;
        if (i < mid) {
            start = i;
        } else {
            start = j;
        }
        while (tempIndex <= right - left) {
            temp[tempIndex++] = array[start++];
        }
        // 赋值
        for (int x = 0; x < temp.length; x++) {
            array[left + x] = temp[x];
        }
    }
}
