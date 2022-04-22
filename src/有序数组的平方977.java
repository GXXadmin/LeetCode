import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/25
 * Time:13:30
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有序数组的平方977 {
    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[] aa = {-7, -3, 2, 3, 11};
        aa = solution977.sortedSquares(aa);
        System.out.println(Arrays.toString(aa));

    }
}

class Solution977 {
    public int[] sortedSquares(int[] nums) {
        //新数组下标
        int count = 0;
        //原数组左右下标
        int left = 0;
        int right = nums.length - 1;
        int help = right;
        //新数组
        int[] aa = new int[right + 1];

        //排序
        while (left <= right) {
/*
            //左小右大
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                aa[help--] = nums[right] * nums[right];
                right--;
            } else {
                //左大右小
                aa[help--] = nums[left] * nums[left];
                left++;
            }
*/

            //左小右大
            aa[help--] = nums[left] * nums[left] < nums[right] * nums[right] ? nums[right] * nums[right--] : nums[left] * nums[left++];

        }
        return aa;
    }
}



/*
class Solution977 {
    public int[] sortedSquares(int[] nums) {
        //新数组下标
        int count = 0;
        //原数组左右下标
        int left = 0;
        int right = nums.length - 1;
        //新数组
        int[] aa = new int[right + 1];

        //排序
        while (left <= right) {

            //左小右大
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                aa[count++] = nums[right] * nums[right];
                right--;
            } else {
                //左大右小
                aa[count++] = nums[left] * nums[left];
                left++;
            }
        }
        //数组转换
        count--;
        left = 0;
        while (count >= 0) {
            nums[left++] = aa[count--];
        }
        return nums;
    }
}
*/














