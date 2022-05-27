package 二分法;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 统计出现次数 {
    public static void main(String[] args) {
        int search = new 统计出现次数().search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int left = findLeft(nums, target);
        if (left == -1) {
            return 0;
        }
        int right = findRight(nums, target);
        return right - left + 1;
    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
