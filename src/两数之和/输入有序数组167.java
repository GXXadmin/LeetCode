package 两数之和;

import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/26
 * Time:19:16
 *
 * 双指针指向左右两端
 * 如果相等，直接返回
 * 结束
 *
 * 如果和大于target
 * j--
 * 如果和小于target
 * i++
 *
 * 最终，i与j就相遇
 * 结束
 *
 */
public class 输入有序数组167 {
    public static void main(String[] args) {
        int[] aa = {2, 7, 11, 15};
        Solution167 solution167 = new Solution167();
        aa = solution167.twoSum(aa, 18);
        System.out.println(Arrays.toString(aa));
    }
}


class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        for (; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
