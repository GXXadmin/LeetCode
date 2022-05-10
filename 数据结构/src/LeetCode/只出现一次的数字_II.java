package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字_II {
    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();
        int[] nums = new int[]{2, 2, 3, 2};
        int i = solution137.singleNumber(nums);
        System.out.println(i);
    }
}

class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }
        return a;




//        Map<Integer, Integer> map = new HashMap();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//
//        int re = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                re = entry.getKey();
//                return re;
//            }
//        }
//        return 0;
    }
}