package leecode.动态规划;

public class 二次买卖股票 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length;
        //定义三维数组,第i天,交易了几次,当前买卖状态
        int[][][] dp = new int[n][3][2];
        //初始化第一天
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            //初始状态
            dp[i][0][0] = dp[i - 1][0][0];
            //处理第一次买入和第一次卖出
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            //处理第二次买入和第二次卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }

        //返回最大值
        int a = Math.max(dp[n-1][0][0],dp[n-1][0][1]);
        int b = Math.max(dp[n-1][1][0],dp[n-1][1][1]);
        return Math.max(Math.max(a,b),dp[n-1][2][0]);


    }
}
