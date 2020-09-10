package leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Al05 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {



        List list = new LinkedList();
        list.add(l1.val);
        ListNode n = l1;
        while (n.next != null) {
            n = n.next;
            list.add(n.val);
        }

        list.add(l2.val);
        n = l2;
        while (n.next != null) {
            n = n.next;
            list.add(n.val);
        }

        Integer[] arrray = (Integer[]) list.toArray(new Integer[list.size()]);
        Arrays.sort(arrray);

        ListNode x = new ListNode();
        x.val = arrray[0];
        n = x;

        for (int i = 1; i < arrray.length; i++) {
            ListNode q = new ListNode();
            q.val = arrray[i];
            n.next = q;
            n = q;
        }

        n = x;
        while (n.next != null) {
            System.out.println(n.val);
            n = n.next;
        }

        return x;

    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(9);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        Al05 al05 = new Al05();
        al05.mergeTwoLists(a1, b1);


    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
