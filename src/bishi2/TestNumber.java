package bishi2;

public class TestNumber {

    public static void check(int i) {
        String str = String.valueOf(i);
        String[] strings = str.split("");//或者通过toCharArray转换为字符数组
        int j = 0;
        for (int n = 0; n < strings.length; n++) {
            if(!strings[n].equals(strings[strings.length-1-j])){
                System.out.println("不是回文数");
                return;
            }else {
                j++;
            }
        }
        System.out.println("是回文数");
    }

    public static void main(String[] args) {
        check(112211111);
    }

}
