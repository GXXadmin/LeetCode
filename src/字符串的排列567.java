import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/30
 * Time:21:05
 * <p>
 * 通过26位的两个数组，分别代表两组字符串在中单个字符在数组中的位置
 * 通过比较两个数组是否相等，来判断cnt2是否可排列为cnt1
 * 数组中的字符个数总是相等的，有左右指针来调控cnt2
 */
public class 字符串的排列567 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "badabc";
        Solution567 solution567 = new Solution567();
        System.out.println(solution567.checkInclusion(s1, s2));

    }
}

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
//        获取s1，s2的长度
        int n = s1.length(), m = s2.length();
//        若s1>s2，则直接返回false
        if (n > m) {
            return false;
        }
//        定义26位数组，用来表示该位的数有几个
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
//        对cnt1进行判断，哪一位有数，哪一位加1
//        同时对cnt2也进行判断更改
        for (int i = 0; i < n; ++i) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
//        此时cnt1与cnt2中字符串的数量相等
//        若cnt1与cnt2完全相等,则返回false
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
//        从第n开始改变cnt2每位的数据
        for (int i = n; i < m; i++) {
//            cnt2[s2.charAt(i) - 'a']++，是让右指针开始右移，每次+1，右指针指向的字符在cnt2中位置
            cnt2[s2.charAt(i) - 'a']++;
//            cnt2[s2.charAt(i - n) - 'a']--，是让左指针开始右移，每次-1，左指针指向的字符在cnt2中位置
            cnt2[s2.charAt(i - n) - 'a']--;
//            判断cnt1与cnt2是否相同
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
