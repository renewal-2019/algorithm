package 链表;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表复制 {
    public Node copyRandomList(Node head) {
//        // 使用map来存储新老链表的映射关系
//        Map<Node, Node> nodeMap = new HashMap<>();
//        Node curr = head;
//        Node pre = null;
//        Node newHead = null;
//        // 先复制简单链表
//        while (curr != null) {
//            Node node = new Node(curr.val);
//            if (pre != null) {
//                pre.next = node;
//            } else {
//                newHead = node;
//            }
//            nodeMap.put(curr, node);
//            pre = node;
//            curr = curr.next;
//        }
//
//        curr = head;
//        Node newCurr = newHead;
//        while (curr != null) {
//            Node newNode = nodeMap.get(curr.random);
//            newCurr.random = newNode;
//            newCurr = newCurr.next;
//            curr = curr.next;
//        }
//        return newHead;

        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    // 考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点
    public Node copyRandomList2(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
