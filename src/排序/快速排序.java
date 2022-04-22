package 排序;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:20:37
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 4, 3, 1, 5};
        if (arr.length <= 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        collate(arr, 0, arr.length - 1);
    }

    public static void collate(int[] arr, int l, int r) {
        //递归结束条件
        if (l >= r) {
            return;
        }
        int mid = quick(arr, l, r);

        // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
        collate(arr, l, mid - 1);
        // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
        // System.out.println(Arrays.toString(arr));
        collate(arr, mid + 1, r);


    }

    public static int quick(int[] arr, int l, int r) {
        // 以左端第一个数为基数
        int temp = arr[l];
        if (l < r) {
            // 从序列右端开始，向左遍历，直到找到小于temp的数

            while (l < r && temp <= arr[r]) {
                r--;
            }
            // 找到后，将这个元素放到最左边的位置
            arr[l] = arr[r];

            // 从序列左端开始，向右遍历，直到找到大于temp的数
            while (l < r && temp >= arr[l]) {
                l++;
            }
            // 找到后，将这个元素放到最右边的位置
            arr[r] = arr[l];
        }
        // 此时arr[l]位置是空的
        arr[l] = temp;
        return l;
    }
}
