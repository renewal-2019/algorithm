package sort;

import java.util.Random;

public class QuickSort {

	/**
	 * 快速排序方法
	 * @param arr 被排序的数组
	 * @param left 指定数组中开始排序的位置
	 * @param right 指定数组中排序结束的位置
	 */
	public static void quickSort(int[] arr, int left, int right) {

		//如果左边索引比右边索引大,那么是不合法的,直接结束方法
		if(left > right) {
			return;
		}

		//定义变量保存基准数,从哪边开始排,就把开始的第一个数当做基准数
		int base = arr[left];

		//定义变量i,指向最左边
		int i = left;

		//定义变量j,指向最右边
		int j = right;

		//当i和j不相遇时, 在循环中进行检索
		while(i != j) {
			//j从右往左检索比基准数小的, 检索到小的就停下
			//如果检索的比基准数大或者相等,就继续检索//&& i < j,这个条件千万不能忘
			while(arr[j] >= base && i < j) {
				j--;//从右往左移动
			}
			while(arr[i] <= base && i < j) {
				i++;//从左往右移动
			}

			//当j和j都停下来的时候,就交换j和j的位置
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		//如果上面while循环的条件不成立, 即i和j相等了,也就是说i和j相遇了,那么就交换基准数和相遇位置的元素
		//把相遇位置的元素赋值给基准数这个位置的元素
		arr[left] = arr[i];
		//把基准数赋值给相遇位置的元素
		arr[i] = base;

		//基准数在这里就归位了,左边的数字都比他小,右边的数字都比他大
		//给基准数左边的排序
		quickSort(arr, left, i - 1);
		//排右边
		quickSort(arr, j + 1, right);

	}

	public static void main(String[] args) {

		int[] array = new int[100000];
		Random r = new Random();
		for(int i = 0; i < array.length; i++) {
			int num = r.nextInt();
			array[i] = num;
		}

		long start = System.currentTimeMillis();

		quickSort(array, 0, array.length - 1);

		long end = System.currentTimeMillis();

		System.out.println(end - start);


	}

}
