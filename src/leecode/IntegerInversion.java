package leecode;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。反转后首位不能为0

public class IntegerInversion {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //判断是否溢出.
            rev = rev *10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerInversion().reverse(5663));
    }

}
