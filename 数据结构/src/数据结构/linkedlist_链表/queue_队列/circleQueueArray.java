package 数据结构.linkedlist_链表.queue_队列;

import java.util.Scanner;

public class circleQueueArray {
    public static void main(String[] args) {
        System.out.println("测试环形队列");
        //创建队列
        circleQueue queue = new circleQueue(4);//最大存储数据还是3个
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)推出程序");
            System.out.println("a(add)添加数据");
            System.out.println("g(get)从队列取出数据");//取出后的数据不在队列中
            System.out.println("h(head)查看队列头数据");//查看后的数据还在队列中
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.hardQueue();
                        System.out.printf("第一个数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("此程序已退出~~");
    }

}

//使用数组模拟队列
class circleQueue {
    private int maxSize;//最大容量
    private int front;//队列头,初始值为0
    private int rear;//队列尾,初始值为0
    private int[] arr;//数组用于存放队列

    //队列构造器
    public circleQueue(int ArrMaxSize) {
        maxSize = ArrMaxSize;
        arr = new int[maxSize];//初始化数组
//        front = 0;//队列头部
//        rear = 0;//队列尾部
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断是否满了
        if (isFull()) {
            System.out.println("队列已满,不能添加数据~");
            return;
        }
        arr[rear] = n;//rear本身就是空位,因此不用后移,直接存
        rear = (rear + 1) % maxSize;//队列后移
    }

    //获得队列的数据,出队列
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空,不能取数据");
        }
        //1.front是第一个元素,先将front存到一个临时变量中方
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        //判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空,无数据~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize,arr[i % maxSize]);
        }
    }

    //获取队列有效长度
    public int size(){
        return (rear + maxSize -front) % maxSize;
    }

    //显示队列头数据,不是取数据
    public int hardQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无头数据~");
        }
        return arr[front];
    }
}
