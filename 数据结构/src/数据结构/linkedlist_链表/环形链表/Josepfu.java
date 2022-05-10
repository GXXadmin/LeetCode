package 数据结构.linkedlist_链表.环形链表;

public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkdeList circleSingleLinkdeList = new CircleSingleLinkdeList();
        circleSingleLinkdeList.addBoy(25);//加入5个小孩节点

        //展示
        //circleSingleLinkdeList.showBoy();
        circleSingleLinkdeList.countBoy(1, 2, 25);
    }
}

//创建单向环形链表
class CircleSingleLinkdeList {

    //创建first节点
    private Boy first = null;

    //添加Boy节点,构成环形链表
    public void addBoy(int nums) {
        //验证nums
        if (nums < 1) {
            System.out.println("nums的值不正确!!!");
            return;
        }
        Boy curBoy = null;//辅助指针
        //创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果第一个boy
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环状
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;//这里的boy是最后一个节点,也是新加入的节点
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判空
        if (first == null) {
            System.out.println("节点为空,无法打印!!!");
            return;
        }
        Boy curBoy = first;//辅助节点,指向头节点
        while (true) {
            System.out.printf("打印的Boy节点为%d\n", curBoy.getNo());
            //判断是否打印完
            if (curBoy.getNext() == first) {
                break;
            }
            //辅助节点后移
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入,出圈Boy

    /**
     * @param starNo   从第几个Boy开始数
     * @param countNum 每次数几个
     * @param nums     一共有多少
     */
    public void countBoy(int starNo, int countNum, int nums) {
        //检验数据
        if (starNo < 1 || starNo > nums || first == null) {
            System.out.println("数据错误,请重新输入!!!");
            return;
        }
        //辅助指针
        Boy helper = first;
        //herple事先指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数前先找到起始Boy
        for (int i = 0; i < starNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时,将first移动到要出圈的节点
        //循环,直到圈中只有一个节点
        while (true) {
            //判断是否中有一个节点
            if (first == helper) {
                break;
            }
            //出圈
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first节点就是出圈的节点
            System.out.printf("boy->%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的节点为%d\n", first.getNo());
    }
}

//创建Boy类,表示Boy节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点

    public Boy() {

    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}








