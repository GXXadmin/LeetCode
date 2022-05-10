package 数据结构.查找;

import java.util.ArrayList;
import java.util.List;

/**
 * User:郭星星
 * Date:2021/5/16
 * Time:10:48
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        //数据分布不均匀时,查找耗费时间久
//        int arr[] = {1,2,3,4,5,6,7,8,9};
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i + 1;
        }
        List<Integer> resIndexList = binarySearch(arr, 0, arr.length - 1, 6);
        System.out.println(resIndexList);
    }

    public static List<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("找");
        //如果left>right,说明递归整个数组也没找到,返回-1
        if (left > right || findVal > arr[arr.length - 1] || findVal < arr[0]) {
            return new ArrayList<Integer>();
        }
        int mid = left + (right - left) * ((findVal - arr[left]) / (arr[right] - arr[left]));
        int midVal = arr[mid];
        //findVal为要查找的数
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<Integer>();
            //向左
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//判断不是
                    break;
                }
                resIndexList.add(temp);
                //再左移
                temp--;
            }

            resIndexList.add(mid);

            //向右
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
