package 数据结构.linkedlist_链表.双向;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("测试双向链表");
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);

        doubleLinkedList.list();
        //修改
//        HeroNode2 newHeroNode = new HeroNode2(4,"小林","包子");
//        doubleLinkedList.update(newHeroNode);
//        System.out.println("============");
//        doubleLinkedList.list();

        //删除
//        doubleLinkedList.del(3);
//        System.out.println("============");
//        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //头节点,不存放数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    //显示列表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }
        //因为头节点不能动,因此需要temp辅助遍历
        HeroNode2 temp = head.next;
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


    //添加节点到单向列表
    //*****当不考虑编号时*****
    //1.找到当前列表的最后节点
    //2.将最后节点的next(此前的next为null)指向新节点
    public void add(HeroNode2 heroNode) {
        //因为头节点不能动,因此需要temp辅助遍历
        HeroNode2 temp = head;
        //遍历列表,找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时,temp指向链表的最后
        //构成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改,根据newHeroNode.no来修改,因此no无法更改
    public void update(HeroNode2 newHeroNode) {
        //判空
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }
        //修改
        //定义辅助变量
        HeroNode2 temp = head.next;
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
            temp.nikename = newHeroNode.nikename;
        } else {
            System.out.printf("没有找到no为%d的节点,无法修改!!!\n", newHeroNode.no);
        }
    }

    //添加
    //找到待删除节点,后temp.next.next
    //比较temp.next.no(就是待删除节点)与待删除节点的no进行比较
    public void del(int no) {
        //判空
        if (head.next == null){
            System.out.println("链表为空,不能删除!!!");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;//找到待删除节点
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到待删除节点
            temp.pre.next = temp.next;//如果为最后一个节点,则temp.pre.next = null
            //temp.next.pre = temp.pre;//如果为最后一个节点,会出问题,temp.next = null  null.pre = null
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("待删除节点%d未找到!!!\n", no);
        }
    }

    //根据排名添加英雄(如果已有排名则添加失败)
    public void addByOrder(HeroNode2 heroNode) {
        //因为是双链表,因此我们要找的temp
        HeroNode2 temp = head;
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
        if (flag) {//找到待删除节点
            System.out.printf("no为%d的编号存在,不能插入!!!\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }

}


//定义HeroNode
class HeroNode2 {
    public int no;
    public String name;
    public String nikename;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点

    public HeroNode2() {

    }

    public HeroNode2(int no, String name, String nikename) {
        this.no = no;
        this.name = name;
        this.nikename = nikename;
    }

    @Override
    public String toString() {
        return "HeroNode{no=" + no + ", name=" + name + ", nikename=" + nikename + '}';
    }

}
