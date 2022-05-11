package LeetCode.LC_163_寻找峰值;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 3, 1};
        int peakElement = solution.findPeakElement(arr);
        System.out.println(peakElement);
    }
}
// 爬山，让数字一直往上爬，通过不断二分，一直到达山顶
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}





