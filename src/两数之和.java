import java.util.HashMap;

/**
 * User:郭星星
 * Date:2021/6/19
 * Time:20:43
 */
class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11, 10};
        int target = 16;
        两数之和 solution = new 两数之和();
        System.out.println(solution.twoSum(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {

//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;

//        for (int i = 0; i < nums.length - 1; i++) {
//            int sum = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == sum) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}




