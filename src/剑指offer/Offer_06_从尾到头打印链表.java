package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Offer_06_从尾到头打印链表 {
    public static void main(String[] args) {

        ListNode l3 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;

        System.out.println(Arrays.toString(reversePrint(l1)));

    }

    public static int[] reversePrint(ListNode head) {
        int index = 0;
        ListNode node = head;
        while (node != null) {
            index++;
            node = node.next;
        }
        int[] result = new int[index];
        index--;
        while (index >= 0) {
            result[index--] = head.val;
            head = head.next;
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
