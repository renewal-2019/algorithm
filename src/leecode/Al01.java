package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 计算两个数组的交集
 */
public class Al01 {

    public int[] intersect(int[] nums1, int[] nums2) {

        List listNums2 = new ArrayList();
        for (int i : nums2) {
            listNums2.add(i);
        }

        List resultList = new ArrayList();

        for (int i : nums1) {
            for (int j = 0; j < listNums2.size(); j++) {
                if (i == (int) listNums2.get(j)) {
                    resultList.add(i);
                    listNums2.remove(j);
                    break;//break的位置一定要分清楚
                }
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length;i++ ){
            result[i] = (int)resultList.get(i);
        }

        return result;

    }

    public int[] intersectUseHashMap(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            intersectUseHashMap(nums2,nums1);
        }

        HashMap hashMap = new HashMap();
        for(int i : nums1){
            int count = (int)hashMap.getOrDefault(i,0) + 1;
            hashMap.put(i,count);
        }

        int[] result = new int[nums1.length];
        int index = 0;
        for(int i : nums2){
            int count = (int)hashMap.getOrDefault(i,0);
            if(count > 0){
                result[index] = i;
                index++;
                count--;
                hashMap.put(i,count);
            }else {
                hashMap.remove(i);
            }
        }

        return Arrays.copyOfRange(result,0,index);


    }

    public int[] intersectUseSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] < nums2[index2]){
                index1++;
            }else if(nums1[index1] > nums2[index2]){
                index2++;
            }else {
                result[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    public static void main(String[] args) {
        Al01 al01 = new Al01();
        int[] result = al01.intersect(new int[]{1,2,1,3}, new int[]{1,1,1,1,2,3});
        int[] result2 = al01.intersectUseHashMap(new int[]{1,2,1,3}, new int[]{1,1,1,1,2,3});
        int[] result3 = al01.intersectUseSort(new int[]{1,2,1,3}, new int[]{1,1,1,1,2,3});
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

}
