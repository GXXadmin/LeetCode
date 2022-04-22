package 排序;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:14:13
 */

/**
 *      选择排序使用了线性查找来寻找最小值，因此在第 1 轮中需要比较 n -1 个数字，第
 * 2 轮需要比较 n -2 个数字……到第 n -1 轮的时候就只需比较 1 个数字了。因此，总的比
 * 较次数与冒泡排序的相同，都是 (n-1)+(n-2)+…+1 ≈ n2/2 次。
 *      每轮中交换数字的次数最多为 1 次。如果输入数据就是按从小到大的顺序排列的，
 * 便不需要进行任何交换。选择排序的时间复杂度也和冒泡排序的一样，都为 O(n2)。
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 7, 8, 9, 3, 5, 4, 2};
        System.out.println(Arrays.toString(collate(arr)));

    }

    public static int[] collate(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int min = 0, t = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            t = arr[j];
            for (int i = j; i < arr.length; i++) {
                if (arr[min] > arr[i]) {
                    min = i;
                }
            }
            arr[j] = arr[min];
            arr[min] = t;
            System.out.println("==================");
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
