import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/27
 * Time:21:00
 * <p>
 * <p>
 * 先将字符串转换为char的数组（使用toCharArray()方法）
 * 循环判定，right<aa.length，当char[i]==32(空格)
 * 翻转left和right之间的字符
 * 最终返回 new String(aa)
 */
public class 反转字符串中的单词557 {
    public static void main(String[] args) {
        String aa = "Let's take LeetCode contest";
        Solution557 solution557 = new Solution557();
        aa = solution557.reverseWords(aa);
        System.out.println(aa);
    }
}

class Solution557 {
    public String reverseWords(String s) {
        //toCharArray(),将字符串转化为char[]数组
        char[] aa = s.toCharArray();
        //将char[]转换为string字符串
        //String tt = new String(aa);
        int left = 0;
        int right = 0;
        while (right < aa.length) {
            if (aa[right] == 32) {
                fan(aa, left, right - 1);
                right++;
                left = ++right;
            }
            right++;
        }
        fan(aa, left, right - 1);
        //System.out.println(Arrays.toString(aa));
        //将char[]转换为string字符串
        return new String(aa);
    }

    public void fan(char[] s, int left, int right) {
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}

