package 排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,2,3,6,9,7,55,33,44};
        冒泡(array);
        System.out.println(Arrays.toString(array));
    }

    public static void 冒泡(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
