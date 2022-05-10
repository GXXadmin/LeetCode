package 数据结构.查找;

/**
 * User:郭星星
 * Date:2021/5/14
 * Time:14:24
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};// 没有顺序的数组
        int index = SeqSearch(arr, 9);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println(index);
        }
    }

    public static int SeqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
