package 数据结构.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        System.out.println(factorial(4));
    }

    //打印
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
//        else {
            System.out.println("n = " + n);
//        }
    }

    //阶乘
    public static int factorial(int n){
        if (n == 1){
            return n;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
