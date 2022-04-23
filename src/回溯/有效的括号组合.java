package 回溯;

import java.util.*;

/**
 * 回溯方法是void还是boolean的判断标准
 * 如果是否符合条件可以用一个数据结构（比如这题的栈是否为空）来存储，那么就是void
 * 如果是否符合条件只能在回溯的过程中进行判断（比如单词搜索中的当前位置的字母与传入的字母是否相等），那么就是Boolean
 */
public class 有效的括号组合 {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(str -> System.out.println(str));
    }

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public static List<String> generateParenthesis(int n) {
        // 存储当前剩余的括号
        Map<String, Integer> kRemainMap = new HashMap<>();
        kRemainMap.put(LEFT, n);
        kRemainMap.put(RIGHT, n);
        List<String> resList = new ArrayList<>();
        dfs(new Stack<>(), resList, kRemainMap, new StringBuilder());
        return resList;
    }

    /**
     * dfs
     *
     * @param leftKStack 已经被使用的左括号
     * @param resList    结果
     * @param kRemainMap 剩余括号的情况
     * @param sb         当前的括号组合
     */
    private static void dfs(Stack<String> leftKStack, List<String> resList, Map<String, Integer> kRemainMap, StringBuilder sb) {
        // 左右括号都用完了，说明组合完成了
        if (kRemainMap.get(LEFT) == 0 && kRemainMap.get(RIGHT) == 0) {
            if (leftKStack.empty()) {
                resList.add(sb.toString());
            }
            return;
        }

        // 放左括号
        if (kRemainMap.get(LEFT) >= 0) { // 有左括号才可以放左括号
            leftKStack.push(LEFT);
            kRemainMap.put(LEFT, kRemainMap.get(LEFT) - 1);
            sb.append(LEFT);
            dfs(leftKStack, resList, kRemainMap, sb);
            leftKStack.pop();
            kRemainMap.put(LEFT, kRemainMap.get(LEFT) + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 放右括号
        if (kRemainMap.get(RIGHT) >= 0 && !leftKStack.empty()) {
            leftKStack.pop();
            kRemainMap.put(RIGHT, kRemainMap.get(RIGHT) - 1);
            sb.append(RIGHT);
            dfs(leftKStack, resList, kRemainMap, sb);
            leftKStack.push(LEFT);
            kRemainMap.put(RIGHT, kRemainMap.get(RIGHT) + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
