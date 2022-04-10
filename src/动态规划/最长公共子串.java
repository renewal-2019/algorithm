package 动态规划;

import java.util.Scanner;

public class 最长公共子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int[][] dp = new int[c1.length + 1][c2.length + 1];
            int res = 0;
            for(int i=c1.length-1;i>=0;i--){
                for(int j=c2.length-1;j>=0;j--){
                    dp[i][j] = c1[i]==c2[j] ? dp[i+1][j+1] + 1 : 0;
                    res = Math.max(res,dp[i][j]);
                }
            }
            System.out.println(res);
        }
    }

    private static void 暴力枚举(char[] c1, char[] c2){
        int res = 0;
        for(int i=0;i<c1.length;i++){
            for(int j=0;j<c2.length;j++){
                int k = 0;
                while((i+k)<c1.length && (j+k)<c2.length && c1[i+k]==c2[j+k]){
                    k++;
                }
                res=Math.max(res,k);
            }
        }
        System.out.println(res);
    }

    private static void 动态规划(){

    }
}
