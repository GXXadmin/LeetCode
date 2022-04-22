package 排序;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:14:44
 */

/**
 *      在插入排序中，需要将取出的数据与其左边的数字进行比较。就跟前面讲的步骤一
 * 样，如果左边的数字更小，就不需要继续比较，本轮操作到此结束，自然也不需要交换
 * 数字的位置。
 *      然而，如果取出的数字比左边已归位的数字都要小，就必须不停地比较大小，交换
 * 数字，直到它到达整个序列的最左边为止。具体来说，就是第 k 轮需要比较 k -1 次。因
 * 此，在最糟糕的情况下，第 2 轮需要操作 1 次，第 3 轮操作 2 次……第 n 轮操作 n -1
 * 次，所以时间复杂度和冒泡排序的一样，都为 O(n2)。
 *      和前面讲的排序算法一样，输入数据按从大到小的顺序排列时就是最糟糕的情况。
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 8, 6, 9, 1};
        System.out.println(Arrays.toString(collate(arr)));
    }

    public static int[] collate(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                for (int j = i + 1; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("====================");
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
