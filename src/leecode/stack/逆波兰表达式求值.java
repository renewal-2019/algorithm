package leecode.stack;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();
        int a;
        int b;
        for (String num : tokens) {// FIXME: 2020/11/6  注意出栈后的运算顺序
            if (num.equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b + a);
            } else if (num.equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            } else if (num.equals("*")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b * a);
            } else if (num.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            } else {
                //是数字则压入栈中
                stack.push(Integer.valueOf(num));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(new 逆波兰表达式求值().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

}
