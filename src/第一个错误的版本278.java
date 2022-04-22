/**
 * User:郭星星
 * Date:2021/9/24
 * Time:20:04
 */
public class 第一个错误的版本278 {
    public static void main(String[] args) {

    }
}
/*

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        //左闭右闭  right = count - 1   left <= right
        int right = n;
        int count = 0;
        while (left<=right) {
            count = left + ((right - left) >> 1);
            if (isBadVersion(count)) {
                right = count - 1;
            } else {
                left = count + 1;
            }
        }
        return left;
    }
}
*/

