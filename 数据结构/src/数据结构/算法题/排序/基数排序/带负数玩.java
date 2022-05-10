package 数据结构.算法题.排序.基数排序;

import java.util.Arrays;

public class 带负数玩 {
    static int arr[] = {-7, 53, 3, 542, 0, -65, 748, 14, -336, 214};
    static int[] zheng = new int[arr.length];
    static int[] fu = new int[arr.length];
    static int ling = 0;
    public static void main(String[] args) {


        for (int i = 0, z = 0, f = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                zheng[z] = arr[i];
                z++;
            } else if (arr[i] < 0) {
                fu[f] = arr[i] * (-1);
                f++;
            } else {
                ling = arr[i];
            }
        }
        ZradixSort(zheng);
        System.out.println(Arrays.toString(zheng));
        FradixSort(fu);
        System.out.println(Arrays.toString(fu));
        System.out.println(ling);

        //radixSort(arr);
    }

    public static void FradixSort(int[] arr) {

        //取得最小数
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        //最大数是几位
        int maxLength = (min + "").length();
        //System.out.println(max + " " +maxLength);
        //10,代表10个桶
        //arr.length,代表一个桶中最多可以放入整个数组(极端情况)
        int[][] bucket = new int[10][arr.length];

        //10,代表是个桶,每个桶一个指针,用于取出桶内元素
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第一轮
            for (int j = 0; j < arr.length; j++) {
                //取出个位数字
                int digitOfElement = arr[j] / n % 10;
                //存如桶中
                //bucket[digitOfElement]代表第几个桶
                //[bucketElementCounts[digitOfElement]中的
                // bucketElementCounts是桶中的指针
                // digitOfElement是第几个桶中的指针
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //从桶中取出,存如原来的数组中
            int index = 0;//arr的下标
            //遍历桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //判断桶中是否有元素
                if (bucketElementCounts[k] != 0) {
                    //循环取出元素
                    //bucketElementCounts[k]代表桶中有几个元素
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                        //System.out.println(bucketElementCounts[k]);
                    }
                }
                //桶指针清零
                bucketElementCounts[k] = 0;
            }
            //转换前
            System.out.println(Arrays.toString(arr));
            //转换
            for (int j = arr.length - 1,f = 0; j > 0; j--,f++) {
                fu[f] = arr[j] * (-1);
            }
            //转换后

        }
    }

    public static void ZradixSort(int[] arr) {

        //取得最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        //最大数是几位
        int maxLength = (max + "").length();
        //System.out.println(max + " " +maxLength);
        //10,代表10个桶
        //arr.length,代表一个桶中最多可以放入整个数组(极端情况)
        int[][] bucket = new int[10][arr.length];

        //10,代表是个桶,每个桶一个指针,用于取出桶内元素
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第一轮
            for (int j = 0; j < arr.length; j++) {
                //取出个位数字
                int digitOfElement = arr[j] / n % 10;
                //存如桶中
                //bucket[digitOfElement]代表第几个桶
                //[bucketElementCounts[digitOfElement]中的
                // bucketElementCounts是桶中的指针
                // digitOfElement是第几个桶中的指针
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //从桶中取出,存如原来的数组中
            int index = 0;//arr的下标
            //遍历桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //判断桶中是否有元素
                if (bucketElementCounts[k] != 0) {
                    //循环取出元素
                    //bucketElementCounts[k]代表桶中有几个元素
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                        //System.out.println(bucketElementCounts[k]);
                    }
                }
                //桶指针清零
                bucketElementCounts[k] = 0;
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
}
