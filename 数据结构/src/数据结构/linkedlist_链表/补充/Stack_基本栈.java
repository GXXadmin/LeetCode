package 数据结构.linkedlist_链表.补充;

import java.util.Stack;

public class Stack_基本栈 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //入栈
        stack.add(111);
        stack.add(222);
        stack.add(333);

        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop(),将栈顶的元素取出
        }
    }
}
