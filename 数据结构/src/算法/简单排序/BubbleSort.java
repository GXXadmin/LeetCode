package 算法.简单排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int i) {
        arr[i] = arr[i] ^ arr[i + 1];
        arr[i + 1] = arr[i] ^ arr[i + 1];
        arr[i] = arr[i] ^ arr[i + 1];
    }
}


