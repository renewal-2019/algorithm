package 动态规划;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        int array[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxTotalOfSubArray(array));
    }

    // dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
    // 那么dp[i] = max{dp[i - 1] + mun[i],num[i]}
    private static int maxTotalOfSubArray(int[] array) {
        int res = array[0];
        int pre = 0;
        for (int num : array) {
            pre = Math.max(pre + num, num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
