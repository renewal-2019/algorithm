package 递归;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果
 */
public class 爬楼梯 {
    private Map<Integer, Integer> valueMap = new HashMap<>();

    public int jumpFloor(int target) {
        return pa(target);
    }

    // 此解法存在重复计算问题
    private int pa(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return pa(target - 1) + pa(target - 2);
    }

    // 通过hash表存储已计算过的值，防止重复计算
    private int niuBiPa(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        if (valueMap.containsKey(target)) {
            return valueMap.get(target);
        }
        int i = niuBiPa(target - 1) + niuBiPa(target - 2);
        valueMap.put(target, i);
        return i;
    }

    // 使用循环代替递归
    private int forCul(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 2; i <= target; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
