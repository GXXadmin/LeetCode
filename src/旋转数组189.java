import java.util.Arrays;
import java.util.logging.Level;

/**
 * User:郭星星
 * Date:2021/9/25
 * Time:15:20
 * <p>
 * <p>
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 */
public class 旋转数组189 {
    public static void main(String[] args) {
        int[] aa = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Solution189 solution189 = new Solution189();
        solution189.rotate(aa, 7);
    }
}

class Solution189 {

    //三次翻转
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //翻转整个数组
        fan_zhuan(nums, 0, n - 1);
        //翻转前k-1个数字
        fan_zhuan(nums, 0, k - 1);
        //翻转后(n-1)-k个数字
        fan_zhuan(nums, k, n - 1);
        //打印输出
        System.out.println(Arrays.toString(nums));
    }

    //翻转函数
    public void fan_zhuan(int nums[], int Start, int end) {
        while (Start < end) {
            int temp = nums[Start];
            nums[Start++] = nums[end];
            nums[end--] = temp;
        }
    }


    //System.out.println(Arrays.toString(nums));

        /*
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    */
}













