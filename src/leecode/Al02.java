package leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Al02 {

    /**
     * 未考虑溢出
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        int a = 0;
        Queue queue = new LinkedList();
        int xx = 0;

        while (x != 0) {
            a = x % 10;
            x /= 10;
            queue.offer(a);
        }

        int num = queue.size();

        while (queue.size() != 0) {
            xx += (int) queue.poll() * Math.pow(10, queue.size());
        }

        return xx;
    }

    public int reverse22(int x) {

        int xx = 0;
        int a = 0;
        while (x != 0) {
            a = x % 10;
            x /= 10;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            if (xx > max / 10 || (xx == max / 10 && a > 7)) {
                return 0;
            }
            if (xx < min / 10 || (xx == min / 10 && a < -8)) {
                return 0;
            }
            xx = xx * 10 + a;
        }
        return xx;
    }

    /**
     * 真的牛皮的解法!!!!!!!!!!!!!
     * @param x
     * @return
     */
    public int niupi(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        Al02 al02 = new Al02();
        System.out.println(al02.reverse(-122030));
        System.out.println(Integer.MAX_VALUE);
        al02.niupi(2108945213);
    }

}
