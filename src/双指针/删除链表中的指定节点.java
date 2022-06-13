package 双指针;

// https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
public class 删除链表中的指定节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = head;
        ListNode cur = head;
        ListNode pre = null;
        // 特殊处理头结点被移除的情况
        if (head.val == val) {
            return head.next;
        }
        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
