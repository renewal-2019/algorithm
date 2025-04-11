package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> addList = new ArrayList<>();
        addList.add(2);
        addList.add(2);
        addList.add(3);
        list.addAll(addList);

        Set<Integer> integerSet = new HashSet<>();
        Collections.addAll(integerSet,1,2,3,3);
        integerSet.addAll(addList);
        integerSet.size();

        list.size();
    }
}
