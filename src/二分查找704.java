/**
 * User:郭星星
 * Date:2021/9/24
 * Time:16:08
 * 如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right) ，那么二分法的边界处理方式则截然不同。
 * <p>
 * 有如下两点：
 * <p>
 * while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
 * if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，
 * 去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
 * <p>
 * left = 8
 * right = 10
 * count = left + ((right - left) >> 1) 防止溢出，最大值为10（right），count = 9
 * count = (left + right)  >> 1 最大值为18，中间值为9
 */
public class 二分查找704 {
    public static void main(String[] args) {
        int[] aaa = {-1, 0, 3, 5, 9, 12};
        Solution704 solution704 = new Solution704();
        int a = solution704.search(aaa, 10);
        System.out.println(a);
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
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


/*
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
*/
        return -1;
    }
}