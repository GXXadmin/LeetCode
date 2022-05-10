package 数据结构.算法题.排序.插入排序;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];//待插入数的数值
            int insertIndex = i - 1;//待插入数前一个数的下标
            //insertIndex >= 0 数组下标从零开始
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                //因为arr[i]被存储在insertVal中,所以可以
                //{101, 34, 119, 1, -1, 89}; ==>{101, 101, 119, 1, -1, 89};
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
