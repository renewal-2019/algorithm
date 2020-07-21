package leecode;

import java.util.Arrays;

/**
 * 不使用额外数组空间,实现数组去重
 */
public class Al06 {

    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        //双指针算法
        //一个慢指针i 和 一个快指针j
        //当两指针对应的值相等时,j继续前进,当两值不相等时,i就前进一位,并赋值j的对应值
        int i = 0;
        for(int j = 1; j< nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,3,5,8,4,4,5,2,6,1,1,3};
        new Al06().removeDuplicates(arrays);
        System.out.println(Arrays.toString(arrays));
    }

}
