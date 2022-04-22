/**
 * User:郭星星
 * Date:2021/9/28
 * Time:21:22
 * <p>
 * 定义left和right两个指针
 * right先跑，跑n次后，left跑
 * 最终让left.next = left.next.next
 * 返回head
 * 结束
 * 注意：left，right节点与head公用一个地址
 */
public class 删除链表的倒数第N个结点19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode19 listNode19 = new ListNode19(1);
        ListNode19 listNode19_2 = new ListNode19(2);
        ListNode19 listNode19_3 = new ListNode19(3);
        ListNode19 listNode19_4 = new ListNode19(4);
        ListNode19 listNode19_5 = new ListNode19(5);
        listNode19.next = listNode19_2;
        listNode19_2.next = listNode19_3;
        listNode19_3.next = listNode19_4;
        listNode19_4.next = listNode19_5;
        solution19.removeNthFromEnd(listNode19, 1);
    }
}

class Solution19 {
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
       /* //修改left和
        ListNode19 left = head;
        ListNode19 right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }

        if (right == null) {
            return head.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;*/

        return removeNode(head, n) == n ? head.next : head;
    }

    public int removeNode(ListNode19 node, int n) {
        //从最后一个节点开始先前return
        if (node.next == null) {
            return 1;
        }
        int m = removeNode(node.next, n);
        //在倒数第n个的位置使node.next = node.next.next
        if (m == n) {
            //说明是删除是最后一个节点
            if (m == 1) {
                node.next = null;
            } else {
                //替换next为next.next
                node.next = node.next.next;
            }
        }
        //每次return时m+1
        return m + 1;
    }
}


class ListNode19 {
    int val;
    ListNode19 next;

    ListNode19() {
    }

    ListNode19(int val) {
        this.val = val;
    }

    ListNode19(int val, ListNode19 next) {
        this.val = val;
        this.next = next;
    }
}
