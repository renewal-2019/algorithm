package leecode;

/**
 * 求数的平方根
 */
public class Al11 {

    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long)mid * mid > x) {//todo 一定要有long转换,一旦int溢出就会造成计算错误
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Al11 al11 = new Al11();
        System.out.println(al11.mySqrt(4));
    }

}
