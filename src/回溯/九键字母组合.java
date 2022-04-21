package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 九键上 2-9 数字上的字母的所有组合
 * leetcode-17
 */
public class 九键字母组合 {
    private static Map<Character, String> numMap = new HashMap<>();

    static {
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = letterCombinations(digits);
        strings.forEach(str -> System.out.println(str));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        if (digits.equals("")) {
            return resList;
        }
        getRes(digits, 0, resList, new StringBuffer());
        return resList;
    }

    private static void getRes(String digits, int index, List<String> resList, StringBuffer tempStr) {
        if (index == digits.length()) { // 说明最后一个数字已经组合完了
            resList.add(tempStr.toString());
            return;
        }
        char currentNum = digits.charAt(index);
        String readyStr = numMap.get(currentNum);
        for (int i = 0; i < readyStr.length(); i++) {
            tempStr.append(readyStr.charAt(i));
            getRes(digits, index + 1, resList, tempStr); // 不能用++index, ++index改变了index的值，会造成后续的数组越界异常
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}
