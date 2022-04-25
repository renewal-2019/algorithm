package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数之和等于零 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        lists.stream().forEach(num -> System.out.println(Arrays.toString(num.toArray())));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            // 当前数与前一个数相等则直接跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 右指针
            int third = nums.length - 1;
            // 左右指针两数的目标和
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; ++second) {
                // 当前数与前一个数相等则直接跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 第三个数（最大的那个数）加上第二个数的和大于目标值时，只能左移第三个数，才有可能得到目标和
                while (third > second && nums[second] + nums[third] > target) {
                    third--;
                }
                // 左右指针重合说明此轮循环没有找到符合的情况
                if (second == third) {
                    break;
                }
                // 第三个数（最大的那个数）加上第二个数的和等于目标值时，加入结果中
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
