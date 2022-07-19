package 动态规划;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/solution/by-nehzil-w61p/
 */
public class 剪绳子1 {
    public static void main(String[] args) {
        System.out.println(maxRes(10));
    }

    public static int maxRes(int length) {
        // 定义dp数组
        int[] dp = new int[length + 1];
        dp[2] = 1;
        for (int i = 3; i <= length; i++) {
            // 遍历j 得到dp【i】的最大值
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
            }
        }
        return dp[length];
    }
}
