/**
 * User:郭星星
 * Date:2021/6/20
 * Time:22:28
 */
public class 整数反转 {
    public static void main(String[] args) {
        Solution7 a = new Solution7();
        System.out.println(a.reverse(11));
    }
}

class Solution7 {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            //x % 10，得到最后一位数字
            n = n * 10 + x % 10;
            //去掉x的最后一位数字
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
