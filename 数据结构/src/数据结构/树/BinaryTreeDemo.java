package 数据结构.树;

/**
 * User:郭星星
 * Date:2021/5/31
 * Time:19:46
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);
        binaryTree.setRoot(root);

        //前序
        System.out.println("前序遍历");
        binaryTree.preOrder();

        //中序
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        //后序
        System.out.println("后序遍历");
        binaryTree.postOrder();

        //前序遍历查找
        System.out.println("前序遍历查找");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了,no=%d,name=%s", resNode.getNo(), resNode.getName());
            System.out.println();
        } else {
            System.out.printf("没找到%d", 5);
        }

        //中序遍历查找
        System.out.println("中序遍历查找");
        resNode = binaryTree.infixOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了,no=%d,name=%s", resNode.getNo(), resNode.getName());
            System.out.println();
        } else {
            System.out.printf("没找到%d", 5);
        }

        //后序遍历查找
        System.out.println("后序遍历查找");
        resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到了,no=%d,name=%s", resNode.getNo(), resNode.getName());
            System.out.println();
        } else {
            System.out.printf("没找到%d", 5);
        }

        //删除
//        System.out.println("删除前!!!");
//        binaryTree.preOrder();
//        binaryTree.delNode(3);
//        System.out.println("删除后!!!");
//        binaryTree.preOrder();
    }
}

//定义 BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树,不能删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSerash(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSerash(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSerash(no);
        } else {
            return null;
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点
    public void delNode(int no) {
        ///思路
        ///*
        //* 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断
        //当前这个结点是不是需要删除结点.
        //
        //2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回
        //(结束递归删除)
        //3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回
        //(结束递归删除)
        //4. 如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
        //5.如果第 4 步也没有删除结点，则应当向右子树进行递归删除.

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    //前序遍历方法
    public void preOrder() {
        System.out.println(this);//输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    //中序遍历方法
    public void infixOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历方法
    public void postOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//输出父节点
    }

    //前序遍历查找
    public HeroNode preOrderSerash(int no) {
        System.out.println("进入前序遍历查找~");
        //比较是不是
        if (this.no == no) {
            return this;
        }

        HeroNode resNode = null;
        //左节点
        if (this.left != null) {
            resNode = this.left.preOrderSerash(no);
        }
        //找到,返回
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSerash(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSerash(int no) {

        HeroNode resNode = null;
        //左节点
        if (this.left != null) {
            resNode = this.left.infixOrderSerash(no);
        }
        //找到,返回
        if (resNode != null) {
            return resNode;
        }
        //比较是不是
        System.out.println("进入中序遍历查找~");
        if (this.no == no) {
            return this;
        }
        //右节点
        if (this.right != null) {
            resNode = this.right.infixOrderSerash(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSerash(int no) {

        HeroNode resNode = null;
        //左节点
        if (this.left != null) {
            resNode = this.left.postOrderSerash(no);
        }
        //找到,返回
        if (resNode != null) {
            return resNode;
        }
        //右节点
        if (this.right != null) {
            resNode = this.right.postOrderSerash(no);
        }
        //找到,返回
        if (resNode != null) {
            return resNode;
        }
        //比较是不是
        System.out.println("进入后序遍历查找~");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}











