package 数据结构.算法题.排序.快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin > end)
            return;
        int temp = arr[begin];
        int i = begin;
        int j = end;
        while (i != j) {
            while (arr[j] >= temp && j > i) {//寻找小于temp的end
                j--;
            }
            while (arr[i] <= temp && j > i) {//寻找大于temp的begin
                i++;
            }
            if (j > i) {//如果找到,就交换位置
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //退出while (i != j)后,此后的j=i
        arr[begin] = arr[j];
        arr[i] = temp;
        quickSort(arr, begin, i - 1);
        quickSort(arr, i + 1, end);
    }
}
