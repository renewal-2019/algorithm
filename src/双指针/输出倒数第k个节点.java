package 双指针;

// https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
public class 输出倒数第k个节点 {
    /**
     * 快慢指针的思想。我们将第一个指针 fast 指向链表的第 k + 1 个节点，
     * 第二个指针 slow 指向链表的第一个节点，此时指针 fast 与 slow
     * 二者之间刚好间隔 k个节点。此时两个指针同步向后走，当第一个指针 fast 走到链表的尾部空节点时，则此时slow 指针刚好指向链表的倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
