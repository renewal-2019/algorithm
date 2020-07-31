package bishi2;

/**
 * 有n部台阶，可以一步或者两步，有多少种走法
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(go(45));
    }

    public static int go(int n) {//此法递归性能很差, leecode提交超时!
        // 存在一步走完的情况
        if (n == 1 || n == 2) {
            return n;
        } else {
            return go(n - 2) + go(n - 1);
        }
    }

    //TODO 动态规划 f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {                                                                                                         
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] arrays = new int[n + 1];
        arrays[1] = 1;
        arrays[2] = 2;
        for (int i = 3; i <= n; i++) {
            arrays[i] = arrays[i - 1] + arrays[i - 2];
        }

        return arrays[n];

    }

    //todo 对动态规划进一步提升,使用滚动数组,因为只需要返回数组最后一个值,
    // 而此值只需要对它的前两个值求和,
    // 所以可以只用三个值来实现滚动数组
    public int climbStairs2(int n) {//这其实就是斐波那契额数列
        int x = 0, y = 0, r = 1;
        for(int i = 1; i <= n; i++){
            x = y;
            y = r;
            r = x + y;
        }
        return r;
    }

}
