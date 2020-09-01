package leecode.september2020;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
public class S1 {
    //假设在第i天卖出,那么买入的价格一定是第0-(i-1)天内的最低价,需要记录最低价以及当前最大差值
    public int maxPrice(int[] array){
        int minValue = Integer.MAX_VALUE;
        int maxPrice = 0;
        for(int i = 0; i< array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
            }else if(array[i] - minValue > maxPrice){
                maxPrice = array[i] - minValue;
            }
        }
        System.out.println(maxPrice);
        return maxPrice;
    }

    public static void main(String[] args) {
        new S1().maxPrice(new int[]{1,2,7,5,9,3,7,8});
    }
}
