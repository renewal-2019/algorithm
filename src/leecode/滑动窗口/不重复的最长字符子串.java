package leecode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class 不重复的最长字符子串 {
    public static int lengthOfLongestSubstring(String s) {
        //保存当前的最大自长度
        int ans = 0;

        //存放字符
        Set charSet = new HashSet();

        //右指针
        //要理解当左指针递增时,右指针也是递增的
        int right = 0;

        for (int i = 0; i < s.length(); i++) {//i 就是左指针

            if (i != 0) {
                //左指针移动一格,需要去除一个字符
                charSet.remove(s.charAt(i - 1));
            }

            while (right < s.length() && !charSet.contains(s.charAt(right))) {
                //移动右指针,直到有重复字符出现 或者到底了
                charSet.add(s.charAt(right));
                right++;
            }

            ans = Math.max(ans, right - i );//因为最后一次right++ 了,所以不用再加一了
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abc"));
    }
}
