package LeetCode;

import java.util.Arrays;

public class 只出现一次的数字_III {
    public static void main(String[] args) {
        Solution260 solution260 = new Solution260();
        int[] nums = new int[]{-1, 0};
        int[] ints = solution260.singleNumber(nums);
        System.out.println(Arrays.toString(ints));
    }
}


class Solution260 {
    public int[] singleNumber(int[] nums) {
        int ab = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ab = ab ^ nums[i];
        }
        int right = ab & (~ab + 1); // 获取最右端的1
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((right & nums[i]) == 0) {
                a = a ^ nums[i];
            }
        }
        return new int[]{a, a ^ ab};
    }
}