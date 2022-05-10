package 数据结构.recursion;

//参考地址
//https://blog.csdn.net/chunqiuwei/article/details/90113087?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161899803116780357216282%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=161899803116780357216282&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-90113087.first_rank_v2_pc_rank_v29&utm_term=%E5%85%AB%E7%9A%87%E5%90%8E
public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("解法%d种", count);
        System.out.println(judgeCount);
    }

    //摆放第n个皇后
    public void check(int n) {
        //一旦第8个皇后摆放完,就输出
        //然后移动第7个皇后,重新摆放第八个
        //再输出,再摆放第7个
        if (n == max) {
            //若符合,就输出皇后摆放位置,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //i最大为8,因为最大只有8列,凡是涉及array[]的,都与列有关
            array[n] = i;
            //判断第n个皇后与之前的皇后是否冲突
            if (judge(n)) {
                //若不冲突,则下一行,判断下一个皇后
                check(n + 1);
            }
        }
    }

    //判断第n个皇后与之前的皇后是否冲突
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            /**
             * n代表第几个皇后
             * array[i] == array[n] 代表第n个皇后与第i个皇后是否再同一列
             * (n - i) 表示第n个皇后与第i个皇后横行之间的差值
             * (array[n] - array[i]) 表示第n个皇后与第i个皇后所在位置(array[] = 列的结果,及改行第几个)
             * Math.abs() 是为了防止出现array[n]再array[i]后面
             */
            if (array[i] == array[n] || (n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印输出皇后摆放位置
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
