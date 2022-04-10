package niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 漂亮度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int c = in.nextInt();
            for (int i = 0; i < c; i++) {
                String str = in.next();
                char[] cc = str.toLowerCase().toCharArray();
                int[] count = new int[128];
                for (int m = 0; m < str.length(); m++) {
                    count[str.charAt(m)]++;
                }
                Arrays.sort(count);
                int s = 26;
                int sum = 0;
                for (int j = count.length - 1; j > 0; j--) {
                    if(count[j] == 0){
                        break;
                    }
                    sum += s*count[j];
                    s--;
                }
                System.out.println(sum);
            }
        }
    }
}
