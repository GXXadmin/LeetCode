package 算法.简单排序;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 22, 7, 23, 4, 0, 77, 3};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (j > 0 && nums[j] < nums[j - 1]) {
                    swap(nums, j);
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int j) {
        nums[j] = nums[j] ^ nums[j - 1];
        nums[j - 1] = nums[j] ^ nums[j - 1];
        nums[j] = nums[j] ^ nums[j - 1];
    }
}
