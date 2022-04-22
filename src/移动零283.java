import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/26
 * Time:14:18
 * <p>
 * 双指针，left负责指向最左端的0，right负责指向最右端的0的下一位，
 * 通过不断交换前进，当right遇到0时，
 * right++
 * left不++
 */
public class 移动零283 {
    public static void main(String[] args) {
        int[] aa = {0, 1, 0, 3, 12};
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes(aa);
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {

        int numsSize = nums.length;
        int i = 0, j = 0;
        for (; i < numsSize; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < numsSize) {
            nums[j++] = 0;
        }


        /*int left = 0;
        int right = 0;

        for (; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (left < right) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                }
                left++;
            }
        }
*/

//        for (; right < nums.length; right++) {
//            if (nums[right] != 0) {
//                /*
//                错误，当地址相同时会出错，为0
//                nums[right] = nums[left] + nums[right];
//                nums[left] = nums[right] - nums[left];
//                nums[right] = nums[right] - nums[left];
//                */
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//            }
//        }

        System.out.println(Arrays.toString(nums));
    }
}
