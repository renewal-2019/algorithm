package bishi;

/**
 * 请实现一个函数，输入一个整数（可能是正数，负数或者0），
 * 分别输出该数的二进制表示中的1和0的个数。
 * 例如把18表示成二进制是10010，有2位是1，3位是0，因此如果输入18，该函数输出2，3。
 */
public class Test {

    public static void count(int n){
        int count = 0;
        int copy = n;
        int number = 1;
        int j = 0;
        while (n!=0){
            count++;
            n = n & (n -1 );
        }

        while (number < copy){
            j++;
            number = number*2;
        }

        int zero = j - count;

        System.out.println(count);
        System.out.println(zero);
    }

    public static void main(String[] args) {
        count(18);
    }

}
