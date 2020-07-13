package leecode;

import java.util.ArrayList;
import java.util.List;

public class Test {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            List<Boolean> list = new ArrayList<>();
            int max = candies[0];
            for(int num : candies){
                if(max < num){
                    max = num;
                }
            }

            for (int i: candies) {
                if(i + extraCandies >= max){
                    list.add(true);
                }else{
                    list.add(false);
                }
            }

            return list;

        }


        public static void main(String[] args) {
            int[] candies = {3,1,5,9,3,5,4};
            int extraCandies = 5;
            new Test().kidsWithCandies(candies,extraCandies);
        }

}
