package 数据结构.stack.后缀表达式_逆波兰表达式.补充.正则表达式;



public class Number {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("-81.23".matches("(-|\\+)?(\\d+)?.?\\d*"));
        System.out.println("+81.23".matches("(-|\\+)?(\\d+)?.?\\d*"));
        System.out.println("xx".matches("(-|\\+)?(\\d+)?.?\\d*"));
        System.out.println(".5".matches("(-|\\+)?(\\d+)*.?\\d*"));
        System.out.println(" ".matches("(-|\\+)?(\\d+)?.?\\d+"));
        System.out.println(".5".matches("(-|\\+)?(\\d+).?\\d\\d*"));
        System.out.println("55.0".matches("(-|\\+)?(\\d+)*.?\\d+"));

    }
}

