package 数据结构.stack.计算器_中缀表达式;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7-6-1-8";

        //数栈与字符栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义变量
        int index = 0;//遍历expression
        int num1 = 0;
        int num2 = 0;
        int oper = 0;//运算符
        int res = 0;//运算最终结构
        char ch = ' ';//将每次遍历的值保存
        String keepNum = "";//用于拼接多位数
        while (true) {
            //获取expression的单个字符串并返回
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch
            if (operStack.isOper(ch)) {//ch是符号
                if (!operStack.isEmpty()) {//判断栈是否为空
                    //不为空则比较两个运算符优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {//要进栈的优先级小
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);//计算
                        numStack.push(res);//计算结果入数栈
                        operStack.push(ch);//当前操作符入符号栈
                    } else {//进栈符号优先级大于符号栈中,符号的优先级
                        operStack.push(ch);
                    }
                } else {
                    //为空则直接入栈
                    operStack.push(ch);
                }
            } else {//ch是数字
                //numStack.push(ch - 48);//此时的数字ch是字符,不是数字.'1'=49
                //两位数及以上的处理
                keepNum += ch;
                if (index == expression.length() - 1) {//判断是否到了最后一位数
                    numStack.push(Integer.parseInt(keepNum));
                } else {//若没有,则再向后走一位判断是数字还是符号
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//清空keepNum
                    }
                }
            }
            //index + 1,并判断expression是否扫描完
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描完毕,计算最后的加减结果
        while (true) {
            //如果符号栈为空,则数栈中只有一个数字,运算结束
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);//计算
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d", expression, res2);
    }
}

//先创建栈
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组,模拟,存栈数据
    private int top = -1;//栈顶

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化
    }

    //查看栈顶
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满~");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法出栈~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //比较运算符优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
















