package fromconggod;

import java.util.Arrays;

/**
 * a,b各有n匹马，假设速度恒定，求最优解下a能否胜出
 */
public class House {

    public static void win(int[] a, int[] b) {

        //先将ab排序
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int count = 0;
        //如果马的个数为奇数个，那么a最多能输n/2
        if (n % 2 == 1) {
            int loseNumber = n / 2;
            //用a最垃圾的马和b最好的马比较（loseNumber匹）
            for (int i = 0; i < loseNumber; i++) {
                if (a[i] > b[n - 1 - i]) {
                    System.out.println("a随便赢");
                    return;
                }
            }
            //剩下的马一一比较,必须全部赢
            for (int i = loseNumber; i < n; i++) {
                if (a[i] > b[i - loseNumber]) {

                } else {
                    System.out.println("a赢不了");
                    return;
                }
            }

            System.out.println("a能赢");

        } else {//如果马的个数为偶数个，那么a最多能输n/2-1
            int loseNumber = n / 2 - 1;
            //用a最垃圾的马和b最好的马比较（loseNumber匹）
            for (int i = 0; i < loseNumber; i++)
                if (a[i] > b[n - 1 - i]) {
                    System.out.println("a随便赢");
                    return;
                }
            //剩下的马一一比较,可以有一把平手的机会
            for (int i = loseNumber; i < n; i++) {
                if (a[i] > b[i - loseNumber]) {
                    count++;
                } else if (a[i] == b[i - loseNumber]) {

                } else {
                    System.out.println("a没机会赢");
                    return;
                }
            }
            if (count > n / 2) {
                System.out.println("a能赢");
            }else {
                System.out.println("a赢不了");
            }

        }

    }

    public static void main(String[] args) {
        win(new int[]{2, 2, 3, 5}, new int[]{2, 2, 1, 3});
    }

}
