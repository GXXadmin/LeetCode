package 排序;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:13:54
 */

/**
 *   在冒泡排序中，第 1 轮需要比较 n -1 次，第 2 轮需要比较 n -2 次……第 n -1 轮需
 * 要比较 1 次。因此，总的比较次数为 (n-1) +(n-2) +…+1 ≈ n2/2。这个比较次数恒定为
 * 该数值，和输入数据的排列顺序无关。
 * 不过，交换数字的次数和输入数据的排列顺序有关。假设出现某种极端情况，如输
 * 入数据正好以从小到大的顺序排列，那么便不需要任何交换操作；反过来，输入数据要
 * 是以从大到小的顺序排列，那么每次比较数字后便都要进行交换。因此，冒泡排序的时
 * 间复杂度为 O(n2)。
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 1, 2, 8, 4, 7, 6};
        System.out.println(Arrays.toString(collate(arr)));
    }

    public static int[] collate(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = arr.length - 1; i > j; i--) {
                int temp = arr[i];
                if (arr[i] < arr[i - 1]) {
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("========================");
        }
        return arr;
    }
}
