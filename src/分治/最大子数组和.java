package 分治;

/**
 * 0.确定区间内需要维护哪些信息
 * 1.分解：将区间左右平分
 * 2.解决子问题：区间分到最小时（只剩下一个元素），直接求解
 * 3.合并区间内的信息，直到求出原始区间内的信息
 *
 */
public class 最大子数组和 {

    public static void main(String[] args) {
        System.out.println(new 最大子数组和().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        // 定义区间[l,r]内需要维护的状态
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum; // 以 l 为左端点的最大子段和
            this.rSum = rSum; // 以 r 为右端点的最大子段和
            this.mSum = mSum; // [l,r] 内的最大子段和
            this.iSum = iSum; // [l,r] 的区间和
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    // 获取区间内的最大子线段和
    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    // 合并左右区间的状态参数
    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        // 如果区间内最大值的子区间没有横跨m，那么最大子数组就在左区间的mSum和右区间的mSum中取其大
        // 如果区间内最大值的子区间横跨了m，那么最大子数组就是左区间的rSum + 右区间的lSum
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
