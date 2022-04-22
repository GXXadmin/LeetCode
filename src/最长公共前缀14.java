import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User:郭星星
 * Date:2021/7/12
 * Time:15:55
 */
public class 最长公共前缀14 {

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        Solution14 solution14 = new Solution14();
        String strings1 = solution14.longestCommonPrefix(strings);
        System.out.println(strings1);
    }

}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        //判断数组内元素
        if (strs.length == 0 && strs == null) {
            return "";
        }
        //获取第一个元素
        String pre = strs[0];

        //与第一个元素后面的元素比较
        for (int i = 1; i < strs.length; i++) {
            //截取字符串长度
            int index = 0;
            //两个字符串比较,取短的字符串长度
            int min = Math.min(pre.length(), strs[i].length());

            //比较两个字符串相同的字符长度
            while (index < min && pre.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            //获得两个字符串的相同字符长度
            pre = pre.substring(0, index);
        }
        return pre;
    }
}


