package leecode;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 因为2*5就有一个0，又因为2的个数肯定比5多，其实也就是求阶乘中包含多少个5
 */
public class Test1 {

    public static int checkZero(int n){
        int count = 0;
        while (n > 4){
            count = count + n/5;
            n /=5;
        }
        return count;

    }

//    public static void checkZero(int n){//阶乘超出了long的范围，所以这个方法不可取
//        long total = (long) n;
//        int count = 0;
//        if(n==0){
//            System.out.println("不符合规定");
//            return;
//        }
//        while (n > 1){
//            total = total*(n-1);
//            n=n-1;
//        }
//        String str = String.valueOf(total);
//        char[] chars = str.toCharArray();
//        int index = chars.length - 1;
//        for(int i = chars.length - 1;i>=0;i--){
//            if(chars[i]=='0'&& index == i){
//                count++;
//                index--;
//            }else {
//                break;
//            }
//        }
//        System.out.println(count);
//    }

    public static void main(String[] args) {
        System.out.println(checkZero(30));
    }

}
