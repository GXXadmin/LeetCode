package 排序;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:15:45
 */

/**
 *      归并排序中，分割序列所花费的时间不算在运行时间内（可以当作序列本来就是分
 * 割好的）。在合并两个已排好序的子序列时，只需重复比较首位数据的大小，然后移动较
 * 小的数据，因此只需花费和两个子序列的长度相应的运行时间。也就是说，完成一行归
 * 并所需的运行时间取决于这一行的数据量。
 *      看一下上面的图便能得知，无论哪一行都是 n 个数据，所以每行的运行时间都为 O(n)。
 * 而将长度为 n 的序列对半分割直到只有一个数据为止时，可以分成 log2n 行，因此，总
 * 共有 log2n 行。也就是说，总的运行时间为 O(nlogn)，这与前面讲到的堆排序相同。
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 5, 1, 2};
        collate(arr, 0, arr.length - 1);
    }

    public static void collate(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        // mid = ((R - L) >> 1) + L
        // mid表示左边数组的最后一个值是下标
        // mid+1表示右边数组的第一个值的下标
        int mid = ((R - L) >> 1) + L;
        collate(arr, L, mid);
        collate(arr, mid + 1, R);
        regression(arr, L, mid, R);
        System.out.println(Arrays.toString(arr));
    }

    public static void regression(int[] arr, int L, int M, int R) {
        // R-L表示下标，下标+1表示元素个数
        int[] help = new int[R - L + 1];
        int i = 0;
        int P1 = L;
        int P2 = M + 1;
        // 两个指针，分别指向两个数组，将小的书添加到help数组中
        while (P1 <= M && P2 <= R) {
            help[i++] = arr[P1] < arr[P2] ? arr[P1++] : arr[P2++];
        }

        // 当有一个数组被遍历完时，将另一个数组中的剩余元素添加到help中
        // 两个while只可能实现一个
        while (P1 <= M) {
            help[i++] = arr[P1++];
        }
        while (P2 <= R) {
            help[i++] = arr[P2++];
        }

        //将help数组复制到arr数组中去
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }
}
