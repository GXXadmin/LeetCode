package 剑指offer;

public class Offer_03_数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(Offer_03_数组中重复的数字.findRepeatNumber(nums));

    }

    public static int findRepeatNumber(int[] nums) {
        int[] num = new int[nums.length];
        for (int j : nums) {
            num[j]++;
            if (num[j] > 1) {
                return j;
            }
        }
        return 0;
    }
}


