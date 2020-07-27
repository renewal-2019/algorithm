package leecode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 */
public class Al08 {

    public int lengthOfLastWord(String s) {

        String x = s.trim();
        if (x.equals("")) {
            return 0;
        }
        int index = x.length() - 1;
        while (index >= 0 && x.charAt(index) != ' '){
            index--;
        }

        return x.length() - 1 - index;

    }

    public static void main(String[] args) {
        Al08 al08 = new Al08();
        System.out.println(al08.lengthOfLastWord("Hello world "));
    }

}
