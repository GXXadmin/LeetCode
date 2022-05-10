package 数据结构.哈希表;

import java.util.Scanner;

/**
 * User:郭星星
 * Date:2021/5/19
 * Time:19:11
 */
public class HashTabDemo {
    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    //加入
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入雇员id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

//创建 HashTab 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray,size个队列
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            //初始化每一个empLinkedListArray,size个队列
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工ID确定员工应该添加在那个表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //查找
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            System.out.printf("在%d链表中找到雇员 id=%d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("没找到");
        }
    }

    //编写散列函数, 使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    //加入
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;//辅助节点

        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;//指针后移
        }
        curEmp.next = emp;//emp加入链表
    }

    //遍历
    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 个链表为空!");
            return;
        }
        System.out.print("第 " + (no + 1) + " 个链表信息为 ");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=>id=%d,name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {//判断是否遍历完链表
                break;
            }
            curEmp = curEmp.next;//后移,继续遍历
        }
        System.out.println();
    }

    //根据id查找
    public Emp findEmpById(int id) {
        //判空
        if (head == null) {
            System.out.println("链表为空!!!");
            return null;
        }

        Emp curEmp = head;//辅助指针
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}








