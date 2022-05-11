package 算法.简单排序;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 2};


    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left = (right - left) / 2;
        process(arr,left,right);
    }
}



