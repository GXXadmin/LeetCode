package 数据结构.树;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/6/7
 * Time:21:43
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapsort(arr);
    }

    public static void heapsort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序!!!");
//        adjustHeap(arr, 1, arr.length);
//        System.out.println(Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        System.out.println(Arrays.toString(arr));

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            System.out.println(Arrays.toString(arr));
            adjustHeap(arr, 0, j);
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;//此时的i,指向
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}
