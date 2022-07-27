package 排序;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,2,3,6,9,7,55,33,44};
        插入排序(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 核心思想：分成已排序区间和未排序区间，取未排序区间的元素插入到已排序区间中的正确位置。
     */
    public static void 插入排序(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; ++i) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if(array[j] > value){
                    // 移动数据
                    array[j +1] = array[j];
                }else {
                    break;
                }
            }
            // 将目标数插入到正确的位置
            array[j+1] = value;
        }
    }
}
