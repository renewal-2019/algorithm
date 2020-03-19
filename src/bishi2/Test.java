package bishi2;

import java.util.*;

public class Test {

    public static void state(int n){
        int i = n/2;

    }

    public static void put(int[] array){

        List list = new ArrayList();

        Set set = new HashSet<Integer>();
        for(int i : array){
            set.add(i);
        }

        Iterator it = set.iterator();
        while (it.hasNext()){
            int a = (int)it.next();
            int number = 0;
            for(int j : array){
                if(a == j){
                    number++;
                }
            }
            if(number == 1){
                list.add(a);
            }
        }

        System.out.println(list);

    }

    public static void main(String[] args) {

        put(new int[]{1, 2, 2, 7,6,6,8,9,3});

    }

}
