package 链表;


import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class 反向输出链表 {
    // 使用栈来反转
    // ps：也可以直接从数组尾部开始填，也可以实现
    public int[] reversePrint(ListNode head) {
        ListNode index = head;
        int num = 0;
        Stack<Integer> intStack = new Stack<>();
        while (index != null) {
            ++num;
            intStack.push(index.val);
            index = index.next;
        }
        int[] res = new int[num];
        int ind = 0;
        while (!intStack.empty()) {
            res[ind] = intStack.pop();
            ++ind;
        }
        return res;
    }
}
