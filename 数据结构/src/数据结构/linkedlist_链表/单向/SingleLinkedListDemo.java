package 数据结构.linkedlist_链表.单向;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //,先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表,加入
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //根据编号顺序插入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        //显示
        //singleLinkedList.list();

//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟...");
//        singleLinkedList.update(newHeroNode);


        //删除节点
//        singleLinkedList.del(4);
//        singleLinkedList.del(1);
//        singleLinkedList.del(3);
//        singleLinkedList.del(2);
        //显示
        singleLinkedList.list();

        System.out.println("有效节点数" + getLength(singleLinkedList.getHead()));

        //查找单链表中的倒数第 k 个结点 新浪面试题
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println("res=" + res);

        System.out.println("============");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("============,没有改变单链表本身的结构");
        reversePrint(singleLinkedList.getHead());
    }

    //将单链表反转
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //从尾到头打印单链表 【百度，要求方式 1：反向遍历 。 方式 2：Stack 栈】
    public static void reversePrint(HeroNode head) {

        //判空
        if (head.next == null) {
            return;
        }

        //创栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        //压栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //遍历列表,返回节点个数,不统计头节点
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int Length = 0;//计数
        HeroNode Cur = head.next;
        while (Cur != null) {
            Length++;
            Cur = Cur.next;//遍历
        }
        return Length;
    }

    //查找单链表中的倒数第 k 个结点 新浪面试题
    //思路
    //1.编写一个方法,接收head节点,接收index
    //2.index 表示倒数第index
    //3.遍历链表
    //4.得到size后,(size - index)
    //5.找到就返回,没找到返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判空
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);//遍历,获取有效节点个数
        //校验
        if (index <= 0 || index > size) {
            return null;
        }
        //辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

//定义SingleLinkedList管理英雄
class SingleLinkedList {
    //头节点,不存放数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向列表
    //*****当不考虑编号时*****
    //1.找到当前列表的最后节点
    //2.将最后节点的next(此前的next为null)指向新节点
    public void add(HeroNode heroNode) {
        //因为头节点不能动,因此需要temp辅助遍历
        HeroNode temp = head;
        //遍历列表,找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时,temp指向链表的最后
        //将最后的节点指向新的节点
        temp.next = heroNode;
    }

    //根据排名添加英雄(如果已有排名则添加失败)
    public void addByOrder(HeroNode heroNode) {
        //因为是单链表,因此我们要找的temp位于添加的前一个节点
        HeroNode temp = head;
        boolean flag = false;//判断标号是否存在
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//找到了
                break;
            } else if (temp.next.no == heroNode.no) {//重复了
                flag = true;//no存在
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {//no存在,不能添加
            System.out.printf("no为%d的编号存在,不能插入!!!\n", heroNode.no);
        } else {
            //插入到temp的后边
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改,根据newHeroNode.no来修改,因此no无法更改
    public void update(HeroNode newHeroNode) {
        //判空
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }
        //修改
        //定义辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//是否找到节点
        while (true) {
            if (temp == null) {//遍历完,没找到
                break;//遍历完列表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nikeName = newHeroNode.nikeName;
        } else {
            System.out.printf("没有找到no为%d的节点,无法修改!!!\n", newHeroNode.no);
        }
    }

    //添加
    //找到待删除节点的前一个节点,后temp.next.next
    //比较temp.next.no(就是待删除节点)与待删除节点的no进行比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;//找到待删除节点
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到待删除节点
            temp.next = temp.next.next;
        } else {
            System.out.printf("待删除节点%d未找到!!!\n", no);
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
        HeroNode temp = head.next;
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

//定义HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;//指向下一个节点

    public HeroNode() {

    }

    public HeroNode(int no, String name, String nikename) {
        this.no = no;
        this.name = name;
        this.nikeName = nikename;
    }

    @Override
    public String toString() {
        return "HeroNode{no=" + no + ", name=" + name + ", nikename=" + nikeName + '}';
    }

}

















