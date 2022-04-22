/**
 * User:郭星星
 * Date:2021/7/17
 * Time:10:21
 */
public class 删除有序数组中的重复项26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] a = {1, 1, 2};
        int temp = solution26.removeDuplicates(a);
        System.out.println(temp);
    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {

        int count = 1;
        int temp = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            for (j = i; j < nums.length; j++) {
                nums[temp] = nums[j];
            }
            i = j;
            if (temp != nums[i]) {
                nums[count++] = nums[i];
                count++;
            }
        }
        return count;
    }
}

