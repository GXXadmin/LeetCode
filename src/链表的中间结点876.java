/**
 * User:郭星星
 * Date:2021/9/28
 * Time:20:42
 * <p>
 * 解法一：
 * 先遍历，用i记录，再遍历找到中间的
 * 结束
 * <p>
 * 解法二：
 * 双指针，left = left.next
 * right = right.next.next
 * 最终返回left
 * 结束
 */
public class 链表的中间结点876 {
    public static void main(String[] args) {
        Solution876 solution876 = new Solution876();
        ListNode876 listNode876 = new ListNode876(1);
        ListNode876 listNode876_2 = new ListNode876(2);
        ListNode876 listNode876_3 = new ListNode876(3);
        ListNode876 listNode876_4 = new ListNode876(4);
        ListNode876 listNode876_5 = new ListNode876(5);
        listNode876.next = listNode876_2;
        listNode876_2.next = listNode876_3;
        listNode876_3.next = listNode876_4;
        listNode876_4.next = listNode876_5;
        solution876.middleNode(listNode876);
    }
}

class Solution876 {
    public ListNode876 middleNode(ListNode876 head) {
        ListNode876 left = head;
        ListNode876 right = head;
        while (right.next != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return left;
    }
}

class ListNode876 {
    int val;
    ListNode876 next;

    ListNode876() {
    }

    ListNode876(int val) {
        this.val = val;
    }

    ListNode876(int val, ListNode876 next) {
        this.val = val;
        this.next = next;
    }
}