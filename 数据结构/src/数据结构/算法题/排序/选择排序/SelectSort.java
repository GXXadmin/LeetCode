package 数据结构.算法题.排序.选择排序;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1, -1, 90, 123};
        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快.
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
        selectSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//存储最下数的下标
            int min = arr[i];//存储最小数的值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];//将最小数的值给min
                    minIndex = j;//将最小数的下标给minIndex
                    //再循环
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
