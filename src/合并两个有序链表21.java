/**
 * User:郭星星
 * Date:2021/7/14
 * Time:10:04
 */
public class 合并两个有序链表21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode21 L1_1 = new ListNode21(1);
        ListNode21 L1_2 = new ListNode21(2);
        ListNode21 L1_4 = new ListNode21(4);
        L1_1.next = L1_2;
        L1_2.next = L1_4;

        ListNode21 L2_1 = new ListNode21(1);
        ListNode21 L2_3 = new ListNode21(3);
        ListNode21 L2_4 = new ListNode21(4);
        L2_1.next = L2_3;
        L2_3.next = L2_4;

        ListNode21 temp = solution21.mergeTwoLists(L1_1, L2_1);
        System.out.println(temp);
    }
}

/**
 *
 */
class Solution21 {

    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        //设立头结点
        ListNode21 prehead = new ListNode21(-1);
        //prev指向头结点
        ListNode21 prev = prehead;

        //while循环合并两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //如果l1小，prev.next就是l1
                prev.next = l1;
                //l1后移
                l1 = l1.next;
            } else {
                //否则prev.next就是l2
                prev.next = l2;
                //l2后移
                l2 = l2.next;
            }
            //每次更新prev，prev后移
            prev = prev.next;
        }

        //
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}

class ListNode21 {
    int val;
    ListNode21 next;

    ListNode21() {
    }

    ListNode21(int val) {
        this.val = val;
    }

    ListNode21(int val, ListNode21 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return
                "val=" + val +
                        ", next=" + next;
    }
}




