import java.util.HashMap;

/**
 * User:郭星星
 * Date:2021/6/20
 * Time:19:54
 * <p>
 * 创建map，max和左右指针
 * 开始循环，right先行
 * 如果map中有key的值与right相等时
 * 改变left指针
 * 然后比较，取出最大值max
 * 将字符存入map
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution1 a = new Solution1();
        String s = "abba";
        System.out.println(a.lengthOfLongestSubstring(s));
        //System.out.println(s.substring(0,2));

    }
}

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        //right指针每次后移一位
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            //当map中有当前字符时，left指针右移
            if (map.containsKey(ch)) {
//                map.get(ch)获取ch在map中的位置（就是right指针前，离right指针最近的位置）
//                left>map.get(ch) + 1，是因为abbc这种形式，让left指针右移一次
//                与left比较是为了防止abba这种情况，
//                当right指向第二个a时,left指向第二个b
//                此时的left指针>map.get(ch) + 1
                left = Math.max(map.get(ch) + 1, left);
            }
//            比较后，取最大值
//            max上一个最长字符串的长度
//            (right - left)两个字符串之间的距离
//            +1是因为
//            abc
//            right指向c，left指向a，2-0=2，再+1=3，right和left只计算了一个

            max = Math.max(max, (right - left) + 1);
            //将字符串存入map，right是字符在字符串中的位置
            //put具有覆盖功能
            map.put(ch, right);
        }
        return max;
    }
}
