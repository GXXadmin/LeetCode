package 数据结构.算法题.排序.冒泡排序;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {7, 3, 2, 4, 6, 5};
        int[] arr = new int[30000];
        for (int i = 0; i < 30000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("前 " + date1Str);
        bubbleSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("后 " + date2Str);
        //System.out.print(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp;//辅助变量
        boolean flag = false;//标识数组本次于上次是否一致
        //排序几次
        for (int j = 0; j < arr.length - 1; j++) {
            //每次排序进行几次交换
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //标识数组本次于上次是否一致
            if (!flag) {//一致
                break;
            } else {//不一致
                flag = false;
            }
        }
    }
}
