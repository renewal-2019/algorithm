package leecode.链表;

import leecode.september2020.ListNode;

public class 两数相加 {
    /**
     * 此解法在总和超出int范围时就会错误
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode x1 = l1;
        ListNode x2 = l2;

        int num1 = 0;
        int num2 = 0;
        int count = 0;
        int total = 0;

        while (x1 != null || x2 != null) {

            if (x1 != null) {
                num1 = x1.val;
                x1 = x1.next;
            } else {
                num1 = 0;
            }
            if (x2 != null) {
                num2 = x2.val;
                x2 = x2.next;
            } else {
                num2 = 0;
            }

            total += (num1 + num2) * Math.pow(10, count);


            count++;
        }

        System.out.println(total);
        ListNode result = new ListNode(total % 10);
        while (total >= 10) {
            total /= 10;
            ListNode node = result;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(total % 10);
        }
        return result;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersXX(ListNode l1, ListNode l2) {
        ListNode x1 = l1;
        ListNode x2 = l2;

        int num1 = 0;
        int num2 = 0;
        int process = 0;

        ListNode result = new ListNode();
        ListNode tail = result;

        while (x1 != null || x2 != null){
            if (x1 != null) {
                num1 = x1.val;
                x1 = x1.next;
            } else {
                num1 = 0;
            }
            if (x2 != null) {
                num2 = x2.val;
                x2 = x2.next;
            } else {
                num2 = 0;
            }

            while (tail.next != null){
                tail = tail.next;
            }
            tail.val = (num1 + num2 + process) % 10;
            tail.next = new ListNode();

            process = (num1 + num2 + process)/10;

        }

        if(process == 1){
            tail.next.val = 1;
        }else {
            tail.next = null;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
//        ListNode x2 = new ListNode(9);
//        ListNode x3 = new ListNode(9);
//        ListNode x4 = new ListNode(9);
//        x1.next = x2;
//        x2.next = x3;
//        x3.next = x4;
        ListNode y1 = new ListNode(5);
//        ListNode y2 = new ListNode(6);
//        ListNode y3 = new ListNode(4);
//        y1.next = y2;
//        y2.next = y3;
//        两数相加.addTwoNumbers(x1,y1);
        两数相加.addTwoNumbersXX(x1,y1);
    }
}
