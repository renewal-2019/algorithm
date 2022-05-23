package 栈;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class 辅助栈 {
    Stack<Integer> valueStack;

    Stack<Integer> minStack;

    public 辅助栈() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        valueStack.push(x);
        Integer peek = minStack.peek();
        minStack.push(Math.min(peek, x));
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
