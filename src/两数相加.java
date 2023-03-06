import java.util.ArrayList;
import java.util.List;

/**
 * User:郭星星
 * Date:2021/6/19
 * Time:21:29
 */


// Definition for singly-linked list.





public class 两数相加 {
    public static void main(String[] args) {
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(4);

        a2.next = a3;
        a3.next = a4;

        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(4);

        b2.next = b3;
        b3.next = b4;

        两数相加 bbb = new 两数相加();

        System.out.println(bbb.addTwoNumbers(a2, b2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode temp = root;
        int count = 0;
        while (l1 != null || l2 != null || count != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + count;
            count = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return root.next;
    }
}
