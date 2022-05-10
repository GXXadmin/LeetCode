package 数据结构.stack.后缀表达式_逆波兰表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //(3+4)*5-6  =>  3 4 + 5 * 6 -
        //4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
//        String suffixExpression = "30 4 + 5 * 6 -";
//        //String suffixExpression = "1 2 3 + 4 * + 5 –";//无法计算
//        //先将3 4 + 5 * 6 - 放入ArrayList中
//        //再将ArrayList传给一个方法
//        List<String> list = getListString(suffixExpression);
//        System.out.println("rpnList = " + list);
//        int res = calculate(list);
//        System.out.println("计算结果是" + res);
//        System.out.println("===========");

        String expression = "1+((2+3)*4)-5";
        List<String> infixExperssionList = toInfixExpressionList(expression);
        System.out.println(infixExperssionList);
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExperssionList);
        System.out.println(suffixExpreesionList);
        System.out.printf("expression=%d", calculate(suffixExpreesionList));
    }

    //中缀存放进List中
    public static List<String> toInfixExpressionList(String s) {
        //ls存放表达式内容
        List<String> ls = new ArrayList<String>();
        int i = 0;//扫描表达式
        String str;//多位数字拼接
        char c;//存放字符
        do {
            //如果是非数字,加入ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;//i后移
            } else {//是数字,需考虑多位数
                str = "";//置空str
                //多位数,while
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //中缀转后缀
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<String>();//符号栈
        List<String> s2 = new ArrayList<String>();//后缀表达式存s2
        for (String item : ls) {
            //数字,进入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则(依次)弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//"("弹栈
            } else {
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，再与 s1 中新的栈顶运算符相比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //比较完后item入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //先将3 4 + 5 * 6 - 放入ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression 分割
        String[] splist = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : splist) {
            list.add(ele);
        }
        return list;
    }

    //运算
    public static int calculate(List<String> ls) {
        //存放suffixExpression
        Stack<String> stack = new Stack<String>();
        //遍历 ls
        for (String item : ls) {
            //这里用正则表达式取数字
            if (item.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(item);
            } else {
                //pop两个数,运算,入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符出错,请检查后重新输入!!!");
                }
                //最终结果入栈
                stack.push("" + res);//小技巧,数字转字符串
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类,比较符号优先级
class Operation {
    private static int ADD = 1;//加
    private static int SUB = 1;//减
    private static int MUL = 2;//乘
    private static int DIV = 2;//除

    //返回优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            case "(":
                result = 0;
                break;
            default:
                System.out.println("符号错误,请重新输入!!!");
                //result = 0;//有错误,后期可能修改   ***已解决***
                break;
        }
        return result;
    }
}









