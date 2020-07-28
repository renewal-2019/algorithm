package leecode;

/**
 * 二进制计算
 */
public class Al10 {

    public String addBinary(String a, String b) {

        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            //从后往前遍历,利用了char字符的ASII码将'1'或'0'转换为对应的int值,当长度较小的字符串到头时用0补齐
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();

    }

}
