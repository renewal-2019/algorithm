package leecode;
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof

import java.util.ArrayList;
import java.util.Arrays;

public class Target {

    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> ans = new ArrayList();
        int i = 1;
        while (target > 0) {
            /*对target做减法，注意此时i不是数列长度*/
            target -= i;
            /*此时i才代表数列长度*/
            i++;
            if (target > 0 && target % i == 0) {
                /*申请长度为i的数组用于储存*/
                int[] temp = new int[i];
                /*将每个数放到数组里*/
                for (int star = target / i, q = 0; star < target / i + i; star++, q++) {
                    temp[q] = star;
                }
                ans.add(temp);
            }
        }
        int size = ans.size();
        int[][] arr = new int[size][];
        /*倒序复制*/
        for (int j = size - 1, k = 0; j >= 0; j--, k++) {
            arr[k] = ans.get(j);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] array = new Target().findContinuousSequence(9);
        Arrays.toString(array);
    }

}
