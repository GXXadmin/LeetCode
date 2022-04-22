package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class LC_20_有效的括号 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String str = "{]}";
        System.out.println(solution20.isValid(str));
        System.out.println("afldkfjla");
    }
}


class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '{') {
                stack.push('}');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else if (stack.empty() || chars[i] != (char) stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}


//class Solution20 {
//    public boolean isValid(String s) {
//        if (s.length() % 2 == 1) {
//            return false;
//        }
//        char[] chars = s.toCharArray();
//        Stack stack = new Stack();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
//                stack.push(chars[i]);
//            } else {
//                if (stack.empty()) {
//                    return false;
//                }
//                char ch = (char) stack.peek();
//                if (ch == '[' && chars[i] == ']') {
//                    stack.pop();
//                } else if (ch == '(' && chars[i] == ')') {
//                    stack.pop();
//                } else if (ch == '{' && chars[i] == '}') {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//        }
//        if (stack.empty()) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//}
