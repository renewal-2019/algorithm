package leecode;
//排排坐，分糖果。
//
//        我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
//
//        给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
//
//        然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
//
//        重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
//
//        返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/distribute-candies-to-people

import java.util.Arrays;

public class Candies {

    public int[] distributeCandies(int candies,int num_people) {

        int remainCandies = candies;
        int eachNumber = 1;

        int[] intArray = new int[num_people];

        while (remainCandies > 0){//有剩余糖果

            for(int n = 0; n < num_people; n++){
                if(remainCandies > eachNumber){
                    intArray[n] = intArray[n] + eachNumber;
                    remainCandies = remainCandies - eachNumber;
                    eachNumber++;
                }else{
                    intArray[n] = intArray[n] + remainCandies;
                    remainCandies = 0;
                }

            }

        }

        return intArray;

    }

    public static void main(String[] args) {

        int[] array = new Candies().distributeCandies(16,5);
        System.out.println(Arrays.toString(array));

    }

}
