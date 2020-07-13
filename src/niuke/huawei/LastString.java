package niuke.huawei;

import java.util.Scanner;

/**
 * 每个单词用空格隔开,求该字符串中最后一个单词的长度
 */
public class LastString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        int n = str.length();
        int number = 0;

        while (str.charAt(n-1) != ' '){//字符用单引号,字符创用双引号
            n--;
            number++;
        }

        System.out.println(number);
    }

}
