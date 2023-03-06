public class 两数相加_2 {
    public static void main(String[] args) {
        ListNode_Link A3 = new ListNode_Link(9);
        ListNode_Link A2 = new ListNode_Link(4, A3);
        ListNode_Link A1 = new ListNode_Link(9, A2);

        ListNode_Link B3 = new ListNode_Link(4);
        ListNode_Link B2 = new ListNode_Link(6, B3);
        ListNode_Link B1 = new ListNode_Link(5, B2);

        Solution_2 solution_2 = new Solution_2();
        ListNode_Link listNode_link = solution_2.addTwoNumbers(A1, B1);

        System.out.println(listNode_link.toString());
    }
}

class Solution_2 {
    public ListNode_Link addTwoNumbers(ListNode_Link l1, ListNode_Link l2) {

        ListNode_Link listNode_link = new ListNode_Link(), head = listNode_link;
        int num = 0;
        while (l1 != null || l2 != null || num != 0) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode_Link(num % 10);
            head = head.next;
            num /=10;
        }
        return listNode_link.next;

    }
}

class ListNode_Link {
    int val;
    ListNode_Link next;

    ListNode_Link() {
    }

    ListNode_Link(int val) {
        this.val = val;
    }

    ListNode_Link(int val, ListNode_Link next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode_Link{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}