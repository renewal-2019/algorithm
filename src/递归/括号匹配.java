package 递归;

import java.util.ArrayList;

/**
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 */
public class 括号匹配 {
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        String strKS = "";
        dfs(strKS, n, n, result);
        return result;
    }

    private void dfs(String strKS, int left, int right, ArrayList<String> result) {
        if (left == 0 && right == 0) { // 括号全部用完,递归结束
            result.add(strKS);
            return;
        }
        // 递归开始时必须先添加左括号
        if (left > 0) { // 只要左括号还有剩余，则可以添加左括号
            dfs(strKS + "(", left - 1, right, result);
        }
        if (right > left) { // 只有当左括号多于右括号时，才可以添加右括号
            dfs(strKS + ")", left, right - 1, result);
        }
    }
}
