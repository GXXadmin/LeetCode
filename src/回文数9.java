/**
 * User:郭星星
 * Date:2021/7/12
 * Time:13:56
 */
public class 回文数9 {
    public static void main(String[] args) {
        Solution回文数9 solution = new Solution回文数9();
        boolean judge = solution.isPalindrome(0);
        System.out.println(judge);
    }
}

class Solution回文数9 {
    public boolean isPalindrome(int x) {
        long n = 0, temp = x;
        if (x >= 0) {
            while (x != 0) {
                //x % 10，得到最后一位数字
                n = n * 10 + x % 10;
                //去掉x的最后一位数字
                x = x / 10;
            }
        }
        return temp < 0 ? false : temp == n;
    }
}









