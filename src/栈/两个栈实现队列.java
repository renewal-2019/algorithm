package 栈;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class 两个栈实现队列 {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public 两个栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (!outStack.empty()) {
            return outStack.pop();
        }

        if (inStack.empty()) {
            return -1;
        }

        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }
}
