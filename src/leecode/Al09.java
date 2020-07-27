package leecode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Al09 {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int index = digits.length - 1;
        digits[index]++;
        while(digits[index] == 10 && index > 0 ){
            digits[index] = 0;
            index--;
            digits[index] += 1;
        }
        if(index == 0 && digits[0] == 10){
            result[0] = 1;
            result[1] = 0;
            for(int i = digits.length - 1 ; i >= 2; i--){
                result[i] = digits[i];
            }
            return result;
        }

        return digits;
    }

    public int[] plusOneMIAO(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Al09 al09 = new Al09();
        System.out.println(Arrays.toString(al09.plusOne(new int[]{9, 9, 9})));

    }

}
