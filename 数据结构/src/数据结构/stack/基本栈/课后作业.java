package 数据结构.stack.基本栈;

public class 课后作业 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Linked linked = new Linked();
        linked.addByOrder(node1);
        linked.addByOrder(node2);
        linked.addByOrder(node3);

        linked.list();
        System.out.println("==========");
        linked.pop();

    }
}

class Linked {

    Node head = new Node(0);

    //入栈
    public void addByOrder(Node node) {
        node.next = head.next;
        head.next = node;
    }

    //出栈
    public void pop() {
        //判空
        if (head.next == null){
            System.out.println("空栈!!!");
            return;
        }
        boolean loop = true;
        while (loop) {
            if (head.next == null) {
                loop = false;
                return;
            }
            Node next = head.next;
            head.next = head.next.next;
            System.out.println(next);
        }
    }

    //显示列表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }
        //因为头节点不能动,因此需要temp辅助遍历
        Node temp = head.next;
        while (true) {
            //判断是否到最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

class Node {
    public int no;
    public Node next;//指向下一个节点

    public Node() {

    }

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Linked{no=" + no + '}';
    }
}
