package bishi;

import java.util.LinkedList;
import java.util.List;

public class Node {

    public static int check(int n) {
        List list = new LinkedList<Integer>();//linkedlist实现了队列接口
        for (int i = 1; i <= n; i++) {
                list.add(i);
        }

        int count = 0;//用来报数
        int index = 0;//用来标记位置
        do {
            count++;
            if (count == 3) {
                list.remove(index);
                count = 0;//报数归零
                index--;//队列少了一个元素，后面的元素下标前进一位
            }
            index++;
            if (index == list.size()) {
                index = 0;
            }
        }while (list.size() > 1);


        return (int)list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(check(2));
    }

}
