package leecode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class Al07 {

    public int searchInsert(int[] nums, int target) {

//        int index = 0;
//        for(int i : nums){
//            if(i == target){
//                return index;
//            }
//            if(i > target){
//                return index;
//            }
//            index++;
//        }
//
//        return index;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {//二分法
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                index = mid;
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Al07 al07 = new Al07();
//        System.out.println(al07.searchInsert(new int[]{1, 3, 5, 8, 9}, 7));
        System.out.println(al07.searchInsert2(new int[]{1, 3, 5, 8, 9}, 5));
    }

}
