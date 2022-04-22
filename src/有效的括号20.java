import java.util.Stack;

/**
 * User:郭星星
 * Date:2021/7/13
 * Time:16:22
 */
public class 有效的括号20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);

            switch (temp) {
                case "(":
                    stack.push(")");
                    break;
                case "{":
                    stack.push("}");
                    break;
                case "[":
                    stack.push("]");
                    break;
                default:
                    if (stack.empty()) {
                        return false;
                    } else {
                        if (!temp.equals(stack.pop())) {
                            return false;
                        }
                    }
            }
        }
        return stack.empty();
    }
}



