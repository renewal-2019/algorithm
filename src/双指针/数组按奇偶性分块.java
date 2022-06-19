package 双指针;

import java.util.Arrays;

public class 数组按奇偶性分块 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{2, 4, 6})));
    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                // 是奇数，left指针直接右移
                left++;
                continue;
            }
            // 此时left指针位置为偶数，需要移动到右半部分
            // 找到当前最右边的奇数
            while (nums[right] % 2 == 0) {
                --right;
                if (right <= left) {
                    return nums;
                }
            }
            // 判断是否符合交换的条件
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else {
                return nums;
            }
        }
        return nums;
    }

    public int[] lRExchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
