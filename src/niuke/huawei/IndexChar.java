package niuke.huawei;

import java.util.Scanner;

/**
 * 一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写
 */
public class IndexChar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String all = "";

        int num = 0;
        all = s.nextLine();
        char one = s.nextLine().charAt(0);
        for (int i = 0; i < all.length(); i++) {
            if (one == all.charAt(i)) {
                num++;
            }
        }

        System.out.println(num);

    }

}
