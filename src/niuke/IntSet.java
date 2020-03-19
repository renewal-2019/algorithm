package niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class IntSet {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder();//用于存放最终结果,必须new，如果用null，则在append的时候会报空指针
        Set setA = new HashSet();//用于去重

        for(int i = str.length() - 1;i >= 0;i--){
            char a = str.charAt(i);
            if(!setA.contains(a)){
                sb.append(a);
                setA.add(a);
            }
        }

        System.out.println(sb);

    }

}
