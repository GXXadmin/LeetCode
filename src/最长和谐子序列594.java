import java.util.Arrays;

public class 最长和谐子序列594 {
    public static void main(String[] args) {
        Solution594 solution594 = new Solution594();
        int[] nums = {1,3,2,2,5,2,3,7};
        int count = solution594.findLHS(nums);
        System.out.print(count);
    }
}

class Solution594 {
    public int findLHS(int[] nums) {
        int count = 0;
        int left = 0;
        int right = 0;
        Arrays.sort(nums);
        for (; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                count = count < right - left + 1 ? right - left + 1 : count;
            }
        }
        return count;
    }
}




