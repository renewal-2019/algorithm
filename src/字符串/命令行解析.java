package 字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 命令行解析 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            List<String> result = useFlag(str);
            System.out.println(result.size());
            result.stream().forEach(i -> System.out.println(i));
        }
    }

    // 使用栈来判断引号
    private static List<String> useStack(String str) {
        List<String> result = new ArrayList<>();
        int head = 0;
        Stack<String> yin = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 引号的优先级高于空格
            if (ch == '"') {
                // 判断是第一个引号还是第二个引号
                if (yin.empty()) { // 是第一个引号
                    yin.push(";");
                    head = i + 1;
                    continue;
                }
                // 是第二个引号
                yin.pop();
                result.add(str.substring(head, i));
                head = i + 1;
                continue;
            }
            // ch 不是引号，也不在引号内
            if (ch == ' ' && yin.empty()) {
                if (i == head) {
                    head++;
                    continue;
                }
                result.add(str.substring(head, i));
                head = i + 1;
            }
        }
        if (head != str.length()) {
            result.add(str.substring(head));
        }
        return result;
    }

    // 使用boolean标记
    private static List<String> useFlag(String str) {
        List<String> result = new ArrayList<>();
        int head = 0;
        // false 表示不在引号内 true 表示在括号内
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 引号的优先级高于空格
            if (ch == '"') {
                // 判断是第一个引号还是第二个引号
                if (!flag) { // 是第一个引号
                    flag = true;
                    head = i + 1;
                    continue;
                }
                // 是第二个引号
                flag = false;
                result.add(str.substring(head, i));
                head = i + 1;
                continue;
            }
            // ch 不是引号，也不在引号内
            if (ch == ' ' && !flag) {
                if (i == head) {
                    head++;
                    continue;
                }
                result.add(str.substring(head, i));
                head = i + 1;
            }
        }
        if (head != str.length()) {
            result.add(str.substring(head));
        }
        return result;
    }
}
