package leecode.september2020;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class S13 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针法
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }

    //也可以使用哈希表法.存储其中一个链表的所有节点,在遍历另一个链表的所有节点,判断对比是否相等

}
