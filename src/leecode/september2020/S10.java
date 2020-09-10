package leecode.september2020;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class S10 {

    /**
     * 使用hash表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(head.next == null){
                return false;
            }

            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    /**
     * 使用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode low = head;
        ListNode fast = head.next;

        while (low != fast){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            low=low.next;
            fast=fast.next.next;
        }

        return true;
    }

}
