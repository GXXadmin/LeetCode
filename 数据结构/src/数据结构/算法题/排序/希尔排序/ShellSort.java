package 数据结构.算法题.排序.希尔排序;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//gap每次隔几个数字,为了确定分组
            for (int i = gap; i < arr.length; i++) {//for是为了让分开的数字,每组都进行比较
                int j = i;
                temp = arr[j];
                while (temp < arr[j - gap] && j - gap >= 0) {//为了确定arr[j]的最终位置
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));


//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) {
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    if (arr[j] > arr[j + gap]) {
//                        temp = arr[j + gap];
//                        arr[j + gap] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));


//        for (int i = 5; i < arr.length; i++) {
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (arr[j] > arr[j + 5]) {
//                    int temp = arr[j + 5];
//                    arr[j + 5] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (arr[j] > arr[j + 2]) {
//                    int temp = arr[j + 2];
//                    arr[j + 2] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
