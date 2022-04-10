package 递归;

import java.util.*;

public class 火车站出栈汇总 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            LinkedList<Integer> origin = new LinkedList<>();
            Stack<Integer> out = new Stack<>();
            for (int i = 0; i < num; i++) {
                origin.add(in.nextInt());
            }
            List<StringBuilder> outList = new ArrayList<>();
            dfs(out, origin, new StringBuilder(), outList);
            List<String> result = new ArrayList<>();
            for(StringBuilder sb : outList){
                String s = sb.toString();
                String replace = s.replace("", " ");
                result.add(replace.trim());
            }
            Collections.sort(result);
            result.stream().forEach(i -> System.out.println(i));
        }
    }

    private static void dfs(Stack<Integer> out, LinkedList<Integer> origin, StringBuilder sb, List<StringBuilder> outList) {
        if (out.empty() && origin.isEmpty()) {
            // 只有深克隆结果，才能将结果存储起来
            outList.add(new StringBuilder(sb));
            return;
        }
        if (!out.empty()) {
            // 出站
            String strOut = out.peek().toString();
            Integer no = out.pop();
            sb.append(strOut);
            dfs(out, origin, sb, outList);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
            out.push(no);
        }
        if (!origin.isEmpty()) {
            // 进站
            Integer poll = origin.pop();
            out.push(poll);
            dfs(out, origin, sb, outList);
            // 回溯
            origin.push(poll);
            out.pop();
        }
    }
}
