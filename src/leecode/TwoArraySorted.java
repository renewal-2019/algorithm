package leecode;
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//初始化 A 和 B 的元素数量分别为 m 和 n。
//链接：https://leetcode-cn.com/problems/sorted-merge-lcci

import java.util.Arrays;

public class TwoArraySorted {//应该使用双指针法，后面改进

    public void merge(int[] A, int m, int[] B, int n) {
        for(int i = 0;i < n;i++){//数组合并
            A[m++] = B[i];
        }
        Arrays.sort(A);//排序
    }

}
