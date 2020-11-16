package leecode.贪心算法;

public class 股票交易 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i =1;i<prices.length;i++){
            sum += Math.max(0,prices[i] - prices[i-1]);
        }
        return sum;
    }
}
