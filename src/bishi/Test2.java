package bishi;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表（无环），请判断是否是回文结构。在删除倒数第K个节点后，是否为回文结构。
 */
public class Test2 {

    public static void check(List<Integer> list){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(Integer i : list){
            sb1.append(i);
        }

        for(int i= list.size() -1 ;i >= 0; i--){
            sb2.append(list.get(i));
        }

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        System.out.println(s1.equals(s2));
    }

    public static void main(String[] args) {
        List e = new LinkedList();
        e.add(1);
        e.add(2);
        e.add(2);
        check(e);
    }

}
