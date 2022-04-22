import java.util.Arrays;

/**
 * User:郭星星
 * Date:2021/9/27
 * Time:20:33
 * <p>
 * 设置左右两个指针
 * s[left]与s[right]交换
 * left == right - 1
 * 跳出
 * 结束
 * <p>
 * 都是字符串，因此可以用逻辑运算，逻辑异或
 * s[left] ^= s[right]; 此时 s[left] = s[left]^s[right]
 * s[right] ^= s[left]; 此时 s[right] = s[left]^s[right]^s[right]，    s[right]=s[left]
 * s[left] ^= s[right]; 此时 s[left] = s[left]^s[right]^(s[right]) <----------\
 * 都是字符串，因此可以用逻辑运算
 */
public class 反转字符串344 {
    public static void main(String[] args) {
        char[] aa = {'h', 'e', 'q', 's', 'l', 'o'};
        Solution344 solution344 = new Solution344();
        solution344.reverseString(aa);
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            fan(s, left, right);
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public void fan(char[] s, int left, int right) {
        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
    }
}





















