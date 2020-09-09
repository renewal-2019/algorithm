package leecode.september2020;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class S09 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        new S09().singleNumber(new int[]{1,1,3,3,2});

        //不使用中间变量,实现两数字的数值交换
        int a = 1,b=6;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }

}
