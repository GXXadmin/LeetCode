import java.beans.Transient;
import java.util.*;

/**
 * User:郭星星
 * Date:2021/9/28
 * Time:22:14
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class ce_shi {

    public static void main(String[] args) {
        ListNode a4 = new ListNode(4);
        ListNode a3 = new ListNode(5, a4);
        ListNode a2 = new ListNode(2, a3);
//        System.out.println(ce_shi.myAtoi("   -42"));
        int[] nums = new int[]{8, 4, 6, 2, 3};

        nums = ce_shi.finalPrices(nums);
        for (int i : nums) {
            System.out.println(i);
        }
        try {
            System.out.println(1/0);
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        } finally {
            System.out.println("finally");
            return;
        }

    }


    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] temp = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            temp[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return temp;

    }


    public static int[] list(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return nums;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] temp = new int[nums.length];
        int index = 0;
        for (int i : nums) {
            while (!stack.isEmpty() && stack.peek() < i) {
                temp[index++] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (index < nums.length) {
            temp[index++] = -1;
        }

        return temp;
    }

}







