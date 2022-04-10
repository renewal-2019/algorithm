package sort;

import java.util.Scanner;

public class zifuchaung {
    private static boolean isChar(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }

    private static boolean jIsBigger(char j, char next) {
        int ij = j;
        int in = next;
        if (j >= 'A' && j <= 'Z') {
            ij = ij + 32;
        }
        if (next >= 'A' && next <= 'Z') {
            in = in + 32;
        }
        return ij > in;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            String str = in.nextLine();
//            char[] charArray = str.toCharArray();
//            for (int i = 0; i < charArray.length; i++) {
//                for (int j = 0; j < charArray.length - i - 1; j++) {
//                    // 判断是否需要处理
//                    if (isChar(charArray[j])) {
//                        int next = j + 1;
//                        while (!isChar(charArray[next]) && next < charArray.length) {
//                            ++next;
//                        }
//                        if (isChar(charArray[next]) && jIsBigger(charArray[j], charArray[next])) {
//                            char temp = charArray[j];
//                            charArray[j] = charArray[next];
//                            charArray[next] = temp;
//                        }
//
//                    }
//
//                }
//
//            }
//            System.out.println(String.valueOf(charArray));
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNext()) { // 注意 while 处理多个 case
//            String a = in.next();
//            int num = in.nextInt();
//            int head = 0;
//            int tail = num-1;
//            int cg = 0;
//            int max = 0;
//            int maxIndex = 0;
//            while(tail < a.length()){
//                String subStr = a.substring(head,tail + 1);
//                for(int i = 0; i<subStr.length();i++){
//                    if(subStr.indexOf(i) == 'C' || subStr.indexOf(i) == 'G'){
//                        cg++;
//                    }
//                }
//                if(cg > max){
//                    max = cg;
//                    maxIndex = tail;
//                }
//                head++;
//                tail++;
//            }
//            System.out.println(a.substring(maxIndex,maxIndex + num + 1));
//        }
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            int num = in.nextInt();
            int head = 0;
            int tail = head + num-1;
            int max = 0;
            int maxIndex = 0;
            while(head + num < a.length()){
                String subStr = a.substring(head,head + num);
                int cg = 0;
                for(int i = 0; i<subStr.length();i++){
                    if(subStr.indexOf(i) == 'C' || subStr.indexOf(i) == 'G'){
                        cg++;
                    }
                }
                if(cg > max){
                    max = cg;
                    maxIndex = head;
                }
                head++;
            }
            System.out.println(a.substring(maxIndex + 1,maxIndex + num + 1));
        }
    }
}
