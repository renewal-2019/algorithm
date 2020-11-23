package leecode.动态规划;

public class 有冷冻期的买卖股票 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;

        int[][] f = new int[n][3];
        //第0天持有
        f[0][0] = -prices[0];
        //第0天不持有,且处于冷冻期
        f[0][1] = 0;
        //第0天不持有,且不处于冷冻期
        f[0][2] = 0;

        for(int i = 1;i<n;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][2] - prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][2],f[i-1][1]);
        }

        return Math.max(f[n-1][1],f[n-1][2]);
    }
}
