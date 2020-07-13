package leecode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public void calculate(){
        Queue<Integer> list = new LinkedList<>();
        //add和offer两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
        list.offer(2);
    }

}
