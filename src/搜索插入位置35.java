/**
 * User:郭星星
 * Date:2021/9/24
 * Time:20:24
 */
public class 搜索插入位置35 {
    public static void main(String[] args) {
        int[] aaa = {1, 3, 5, 6};
        Solution35 solution35 = new Solution35();
        int a = solution35.search(aaa, 2);
        System.out.println(a);
    }
}


class Solution35 {
    public int search(int[] nums, int target) {
/*
        int left = 0;
        //左闭右开  right = count   left < right
        int right = nums.length;
        int count = 0;

        while (left < right) {
            //防止溢出
            count = left + ((right - left) >> 1);
            if (nums[count] < target) {
                left = count + 1;
            } else if (nums[count] > target) {
                right = count;
            } else {
                return count;
            }
        }
*/


        int left = 0;
        //左闭右闭  right = count - 1   left <= right
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            count = left + ((right - left) >> 1);
            if (nums[count] < target) {
                left = count + 1;
            } else if (nums[count] > target) {
                right = count - 1;
            } else {
                return count;
            }
        }
        return right + 1;
    }
}
