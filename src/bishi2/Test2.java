package bishi2;

/**
 * 有n部台阶，可以一步或者两步，有多少种走法
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(go(10));
    }

    public static int go(int n) {
        // 存在一步走完的情况
        if (n == 1 || n == 2) {
            return n;
        } else {
            return go(n - 2) + go(n - 1);
        }
    }

}
