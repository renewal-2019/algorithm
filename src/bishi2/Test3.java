package bishi2;

import java.io.FileReader;

/**
 * 写一个方法，输入一个txt文件的文件名和一个字符串，统计这个字符串在这个文件中出现的次数？
 */
public class Test3 {

    public static void calculate(String path, String st) throws Exception {
//        FileInputStream in = new FileInputStream("F:\\IO\\String.txt");

        FileReader in = new FileReader(path);
        String str = null;
        int number = 0;//计数次数
        int i = 0;//记录索引
        char[] chars = new char[20];
        int length = 0;
        while ((length = in.read(chars)) != -1) {

            System.out.println(str = new String(chars, 0, length));

        }

        while (true){
            if(str.indexOf(st,i) == -1){//从起始第i位开始判断
                break;
            }else {
                number++;
                i = str.indexOf(st,i)+st.length();
            }
        }

        System.out.println(number);

    }

    public static void main(String[] args) throws Exception {
        calculate("F:\\IO\\String.txt", "aaa");
    }

}
