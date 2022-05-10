package 数据结构.算法题.排序.基数排序;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {

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
            System.out.println(Arrays.toString(arr));
        }
        /*//第一轮
        for (int j = 0; j < arr.length; j++) {
            //取出个位数字
            int digitOfElement = arr[j] % 10;
            //存如桶中
            //bucket[digitOfElement]代表第几个桶
            //[bucketElementCounts[digitOfElement]中的
            // bucketElementCounts是桶中的指针
            // digitOfElement是第几个桶中的指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //从桶中取出,存如原来的数组中
        index = 0;//arr的下标
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
        System.out.println(Arrays.toString(arr));

        //第二轮
        for (int j = 0; j < arr.length; j++) {
            //取出十位数字
            int digitOfElement = arr[j] / 10 % 10;
            //存如桶中
            //bucket[digitOfElement]代表第几个桶
            //[bucketElementCounts[digitOfElement]中的
            // bucketElementCounts是桶中的指针
            // digitOfElement是第几个桶中的指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //从桶中取出,存如原来的数组中
        index = 0;//arr的下标
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
        System.out.println(Arrays.toString(arr));

        //第三轮
        for (int j = 0; j < arr.length; j++) {
            //取出百位数字
            int digitOfElement = arr[j] / 100 % 10;
            //存如桶中
            //bucket[digitOfElement]代表第几个桶
            //[bucketElementCounts[digitOfElement]中的
            // bucketElementCounts是桶中的指针
            // digitOfElement是第几个桶中的指针
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //从桶中取出,存如原来的数组中
        index = 0;//arr的下标
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
        }
        System.out.println(Arrays.toString(arr));*/
    }
}



















