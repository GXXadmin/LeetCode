package 数据结构.linkedlist_链表.单向;

public class 课后作业_合并两个单链表 {
    public static void main(String[] args) {
        HeroNode0 hero1 = new HeroNode0(1, "宋江", "及时雨");
        HeroNode0 hero2 = new HeroNode0(2, "卢俊义", "玉麒麟");
        HeroNode0 hero3 = new HeroNode0(3, "吴用", "智多星");
        HeroNode0 hero4 = new HeroNode0(4, "林冲", "豹子头");

        SingleLinkedListTwo list1 = new SingleLinkedListTwo();
        list1.addByOrder(hero4);
        list1.addByOrder(hero1);
        System.out.println("链表一");
        list1.list();


        SingleLinkedListTwo list2 = new SingleLinkedListTwo();
        list2.addByOrder(hero3);
        list2.addByOrder(hero2);
        System.out.println("链表二");
        list2.list();

        System.out.println("链表三,整合");
        SingleLinkedListTwo mergeList = merge(list1, list2);
        mergeList.list();

    }

    //整合
    public static SingleLinkedListTwo merge(SingleLinkedListTwo s1, SingleLinkedListTwo s2) {
        HeroNode0 head = new HeroNode0(0, "", "");
        HeroNode0 preHerNode = head;
        SingleLinkedListTwo mergeList = new SingleLinkedListTwo();
        mergeList.setHead(head);
        HeroNode0 heroNode1 = s1.getHead().next;
        HeroNode0 heroNode2 = s2.getHead().next;
        while (heroNode1 != null && heroNode2 != null) {
            if (heroNode1.no < heroNode2.no) {
                preHerNode.next = heroNode1;
                heroNode1 = heroNode1.next;
            } else {
                preHerNode.next = heroNode2;
                heroNode2 = heroNode2.next;
            }
            //后移，为下一次排序做准备
            preHerNode = preHerNode.next;
        }
        preHerNode.next = (heroNode1 == null) ? heroNode2 : heroNode1;

        // 返回合并后的链表
        return mergeList;
    }


}

//定义SingleLinkedList管理英雄
class SingleLinkedListTwo {

    //头节点,不存放数据
    private HeroNode0 head = new HeroNode0(0, "", "");

    public HeroNode0 getHead() {
        return head;
    }

    public void setHead(HeroNode0 head) {
        this.head = head;
    }

    //根据排名添加英雄(如果已有排名则添加失败)
    public void addByOrder(HeroNode0 heroNode) {
        //因为是单链表,因此我们要找的temp位于添加的前一个节点
        HeroNode0 temp = head;
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

    //显示列表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }
        //因为头节点不能动,因此需要temp辅助遍历
        HeroNode0 temp = head.next;
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

//定义HeroNode0
class HeroNode0 {
    public int no;
    public String name;
    public String nikename;
    public HeroNode0 next;//指向下一个节点

    public HeroNode0() {

    }

    public HeroNode0(int no, String name, String nikename) {
        this.no = no;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "HeroNode0{no=" + no + ", name=" + name + ", nikename=" + nikename + '}';
    }

}
