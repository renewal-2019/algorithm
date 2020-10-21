package leecode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 常数时间内获取栈中最小元素
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 *另一种方法是使用静态内部类node,里面维护一个当前最小值
 **/
