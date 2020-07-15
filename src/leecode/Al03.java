package leecode;

/**
 * 查找字符串数组中的最长公共前缀
 */
public class Al03 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {//防止输入为空数组
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        //求出字符串的最小长度防止空指针
        int num = strs[0].length();
        for (String str : strs) {
            if (str.length() < num) {
                num = str.length();
            }
        }

        if (num == 0) {//防止元素均为空字符
            return "";
        }

        char x = strs[0].charAt(0);
        for (int i = 0; i < num; i++) {
            for (String str : strs) {
                if (x != str.charAt(i)) {
                    return String.valueOf(stringBuilder);
                }
            }
            stringBuilder.append(x);
            if (i < num - 1) {//因为索引是从0开始的
                x = strs[0].charAt(i + 1);
            }
        }
        return String.valueOf(stringBuilder);
    }

    /**
     * 二分查找法
     */
    public String longestCommonPrefix2(String[] strs) {

        //排除傻比输入
        if (strs == null || strs.length == 0) {
            return "";
        }
        int num = strs[0].length();
        for (String str : strs) {
            if (str.length() < num) {
                num = str.length();
            }
        }
        if (num == 0) {
            return "";
        }

        //二分查找
        int low = 0;
        int high = num;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (prefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);

    }

    public boolean prefix(String[] strings, int index) {
        String str = strings[0].substring(0, index);
        int count = strings.length;
        for (int i = 1; i < count; i++) {
            String strX = strings[i];
            for (int j = 0; j < index; j++) {
                if (str.charAt(j) != strX.charAt(j) ) {
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {

        Al03 al03 = new Al03();
        System.out.println(al03.longestCommonPrefix(new String[]{"as4", "asd", "asd"}));
        System.out.println(al03.longestCommonPrefix2(new String[]{"as4", "asd", "asd"}));

    }

}
