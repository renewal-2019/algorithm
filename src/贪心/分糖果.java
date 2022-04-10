package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * m个糖果，n个小孩
 * m<n
 * 糖果大小不同，小孩对糖果大小的需求也不同
 * 找出小孩被满足的个数最多的那个方案
 */
public class 分糖果 {
    public static void main(String[] args) {
        int[] child = new int[]{1, 2, 3, 8, 9, 4, 2};
        int[] candies = new int[]{1, 4, 3, 5, 5, 1};
        List<int[]> solution = getSolution(candies, child);
        for (int[] item : solution) {
            System.out.println(Arrays.toString(item));
        }
    }

    private static List<int[]> getSolution(int[] candies, int[] child) {
        List<int[]> res = new ArrayList<>();
        // 每次从剩下的小孩中，找出对糖果需求最小的，然后发给他能够满足他需求的最小的糖果
        // 1.构造排好序的栈
        LinkedList<Element> sortedCandies = getSortedStack(candies);
        LinkedList<Element> sortedChild = getSortedStack(child);
        while (!sortedChild.isEmpty()) {
            if (sortedCandies.isEmpty()) {
                break;
            }
            Element readyChild = sortedChild.pop();
            Element readyCandy = sortedCandies.pop();
            while (readyChild.getValue() > readyCandy.getValue()) {
                if (sortedCandies.isEmpty()) {
                    break;
                }
                readyCandy = sortedCandies.pop();
            }
            if (readyChild.getValue() <= readyCandy.getValue()) {
                res.add(new int[]{readyChild.index, readyCandy.index});
            }
        }
        return res;
    }

    private static LinkedList<Element> getSortedStack(int[] array) {
        LinkedList<Element> res = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            Element element = new Element(i, array[i]);
            res.add(element);
        }
        res.sort((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });
        return res;
    }

    private static class Element {
        private int index;

        private int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
