package 数据结构.查找;

import java.util.ArrayList;
import java.util.List;

/**
 * User:郭星星
 * Date:2021/5/14
 * Time:14:35
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        List<Integer> resIndexList = binarySearch(arr, 0, arr.length - 1, 1234);
        System.out.println(resIndexList);
    }

    public static List<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("找");
        //如果left>right,说明递归整个数组也没找到,返回-1
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
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