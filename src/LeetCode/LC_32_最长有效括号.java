package LeetCode;

import java.util.Map;
import java.util.Stack;

public class LC_32_最长有效括号 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
//        String s = "()()";
//        String s = "(()";
//        String s = "";
        String s = "()(())";

        System.out.println(solution32.longestValidParentheses(s));
    }
}


class Solution32 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}




//class Solution32 {
//    public int longestValidParentheses(String s) {
//        char[] chars = s.toCharArray();
//        int left = 0;
//        int right = 1;
//        int count = 0;
//        int returnCount = 0;
//        while (right < chars.length) {
//            a:
//            if (left >= 0 && right < chars.length && chars[left] == '(' && chars[right] == ')') {
//                count += 2;
//                while (left - 1 >= 0 && right + 1 < chars.length && chars[--left] == chars[right++]) {
//                    count += 2;
//                }
//            } else {
//                returnCount = Math.max(count, returnCount);
//                count = 0;
//            }
//            right+=2;
//            left = right - 1;
//            returnCount = Math.max(count, returnCount);
//
//        }
//
//        return returnCount;
//    }
//}

