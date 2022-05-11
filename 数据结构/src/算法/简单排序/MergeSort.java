package 算法.简单排序;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 2};
        int[] process = process(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(process));

    }

    public static int[] process(int[] arr, int left, int right) {
        if (left == right) {
            return null;
        }
        int middle = left + ((right - left) >> 2);
        process(arr, left, middle);
        process(arr, middle + 1, right);
        merge(arr, left, middle, right);
        return arr;
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = middle + 1;
        int i = 0;
        while (p1 <= middle && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left++] = help[j];
        }
    }
}



