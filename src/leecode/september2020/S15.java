package leecode.september2020;

/**
 * 获取数组最大元素和,元素不可相邻
 */
public class S15 {
    // 动态规划
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0 ){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }

        return dp[dp.length - 1];

    }
}
