import java.util.HashMap;
import java.util.Map;

/**
 * User:郭星星
 * Date:2021/7/12
 * Time:14:25
 */
public class 罗马数字转整数13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        Solution13 solution13 = new Solution13();
        int temp = solution13.romanToInt(s);
        System.out.println(temp);
    }
}

class Solution13 {
    public int romanToInt(String s) {
        int temp = 0;
        int L = s.length();

        //存储对应数
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };


        int pre = map.get(s.charAt(0));
        //循环获取
        for (int i = 1; i < L; i++) {
            int sum = map.get(s.charAt(i));
            //sum < map.get(s.charAt(i + 1)),比较当前数与下一位数的大小
            //XIV,相当于10-1+5 = 15
            //i < L - 1,放在if的判断中

            //i从0开始,i < L - 1就是倒数第二位数的判断
            //最后一位数一定是直接加上去的,所以不用比较
            if (i < L && pre < sum) {
                temp -= pre;
            } else {
                temp += pre;
            }
            pre = sum;
        }
        temp += pre;
        return temp;
    }
}








