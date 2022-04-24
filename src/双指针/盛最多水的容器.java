package 双指针;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        int par[] = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(par));
    }

    public static int maxArea(int[] height) {
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;
        // 存储最大值
        int res = 0;
        while (left <= right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) { // 左边界较小时，移动左指针
                left++;
            } else { // 右边界较小时移动右指针
                right--;
            }
        }
        return res;
    }
}
