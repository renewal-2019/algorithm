package 二分法;

public class 平方根 {
    public static void main(String[] args) {
        System.out.println(平方根(11));
    }

    // 保留6位小数
    private static double 平方根(int number) {
        double target = number;
        double left = 0;
        double right = number;
        double mid = right / 2D;
        while (mid * mid != target) {
            if (mid * mid > target) {
                right = mid;
                mid = (left + right) / 2D;
            } else if (mid * mid < target) {
                left = mid;
                mid = (left + right) / 2D;
            }
            String s = String.valueOf(mid);
            if (s.contains(".")) {
                String[] split = s.split("\\.");
                Integer intMid = Integer.valueOf(split[0]);
                if (intMid * intMid == number) {
                    return intMid;
                }
                if (split[1].length() >= 11) {
                    return mid;
                }
            }
        }

        return mid;
    }
}
