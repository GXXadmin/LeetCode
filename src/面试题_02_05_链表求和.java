public class 面试题_02_05_链表求和 {
    public static void main(String[] args) {
        link_add A3 = new link_add(9);
        link_add A2 = new link_add(4);
        A2.next = A3;
        link_add A1 = new link_add(9);
        A1.next = A2;

        link_add B3 = new link_add(9);
        link_add B2 = new link_add(4);
        B2.next = B3;
        link_add B1 = new link_add(9);
        B1.next = B2;

        Solution_02_05 solution_02_05 = new Solution_02_05();
        link_add link_add = solution_02_05.addTwoNumbers(A1, B1);
        System.out.println(link_add.toString());

    }


}

class Solution_02_05 {
    public link_add addTwoNumbers(link_add l1, link_add l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        String num1 = "";
        String num2 = "";
        while (l1 != null) {
            num1 += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 += l2.val;
            l2 = l2.next;
        }
        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
        String sumString = sum + "";
        System.out.println(sum);
        link_add link_add = new link_add(-1), head = link_add;
        int sub = sumString.length() - 1;
        while (sub >= 0) {
            head.next = new link_add(sumString.charAt(sub) - 48);
            head = head.next;
            sub--;
        }



        return link_add.next;
    }
}

class link_add {
    int val;
    link_add next;

    link_add(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "link_add{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
