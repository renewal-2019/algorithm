package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoSort {

    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int com;
                    com = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = com;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {1,3,8,4,1,9,3,6};
        sortArray(array);
    }

}
