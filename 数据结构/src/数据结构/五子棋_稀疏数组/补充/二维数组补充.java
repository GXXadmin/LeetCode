package 数据结构.五子棋_稀疏数组.补充;

public class 二维数组补充 {
    public static void main(String[] args) {
        //定义一个一维数组
        int[] a = new int[10];
        //为一维数组赋值
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        //for-each遍历一维数组
        for (int arr : a) {//(类型 变量名 : 集合)
            System.out.print(arr + "\t");
        }

    }
}
