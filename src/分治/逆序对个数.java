package 分治;

public class 逆序对个数 {
    private int num = 0;

    public static void main(String[] args) {
        System.out.println(new 逆序对个数().count(new int[]{1, 4, 3, 2}, 4));
    }

    private int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    // 在归并排序中进行统计
    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                num += (q - i + 1); // q和i之间的数都比当前i的数大，所以就有q-i+1个逆序对
                temp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for (i = 0; i <= r - p; ++i) { // temp复制会a
            a[p + i] = temp[i];
        }
    }

}
