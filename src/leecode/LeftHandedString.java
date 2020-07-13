package leecode;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class LeftHandedString {

    public String reverseLeftWords(String s, int n){
        if(s.length() < n){
            return "字数超限";
        }
        String sub = s.substring(0,n);
        s = s.substring(n) + sub;
        System.out.println(s);

        return s;
    }

    public static void main(String[] args) {
        new LeftHandedString().reverseLeftWords("abcdrrr", 3);
    }

}
