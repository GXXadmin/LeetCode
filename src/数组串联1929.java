import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/7/12
 * Time:13:41
 */
public class 数组串联1929 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution1929 solution1929 = new Solution1929();
        nums = solution1929.getConcatenation(nums);
        System.out.println(Arrays.toString(nums));
    }
}


class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int[] num = new int[nums.length << 1];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
        }

        for (int j = nums.length; j < nums.length << 1; j++) {
            num[j] = nums[j - nums.length];
        }
        return num;
    }
}





