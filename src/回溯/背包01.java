package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 背包01 {
    public static void main(String[] args) {
        int[] beiBao = new int[]{1, 2, 3};
        List<int[]> result = new ArrayList<>();
        int[] resA = new int[beiBao.length];
        dfs(0, 0, beiBao, 3, 3, result, resA);
        result.stream().forEach(i -> System.out.println(Arrays.toString(i)));
    }

    private static void dfs(int curr, int currW, int[] beiBao, int limitN, int limitW, List<int[]> result, int[] resA) {
        if (currW == limitW || curr == limitN) {
            // 添加的时候必须深克隆一个，才能真正的存储起来
            result.add(Arrays.copyOfRange(resA, 0, resA.length));
            return;
        }

        // 选择不放当前物品
        dfs(curr + 1, currW, beiBao, limitN, limitW, result, resA);
        // 选择放置当前物品（前提是背包还放的下）
        if (currW + beiBao[curr] <= limitW) {
            resA[curr] = beiBao[curr];
            dfs(curr + 1, currW + beiBao[curr], beiBao, limitN, limitW, result, resA);
            resA[curr] = 0;
        }
    }
}
