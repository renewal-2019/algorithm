package 哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 **/
public class 两数之和 {
    public static void main(String[] args) {
        int[] test = new int[]{2,2,5,8,43,4};
        int[] target = target(test, 4);
        System.out.println(Arrays.toString(target));
    }

    private static int[] target(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[]{i,hash.get(target - nums[i])};
            }
            hash.put(nums[i], i);
        }

        return new int[]{};
    }
}
