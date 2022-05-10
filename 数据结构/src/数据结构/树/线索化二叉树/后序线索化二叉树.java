package 数据结构.树.线索化二叉树;

/**
 * User:郭星星
 * Date:2021/6/5
 * Time:23:27
 */
public class 后序线索化二叉树 {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNodeH root1 = new HeroNodeH(1, "tom");
        HeroNodeH node3 = new HeroNodeH(3, "jack");
        HeroNodeH node6 = new HeroNodeH(6, "smith");
        HeroNodeH node8 = new HeroNodeH(8, "mary");
        HeroNodeH node10 = new HeroNodeH(10, "king");
        HeroNodeH node14 = new HeroNodeH(14, "dim");
        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root1.setLeft(node3);
        root1.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);

        if (node14.getLeft() != null) {
            node14.getLeft().setParent(node14);
        }
        if (node14.getRight() != null) {
            node14.getRight().setParent(node14);
        }

        if (node8.getLeft() != null) {
            node8.getRight().setParent(node8);
        }
        if (node8.getRight() != null) {
            node8.getRight().setParent(node8);
        }

        if (node10.getLeft() != null) {
            node10.getRight().setParent(node10);
        }
        if (node10.getRight() != null) {
            node10.getRight().setParent(node10);
        }

        if (node3.getLeft() != null) {
            node3.getRight().setParent(node3);
        }
        if (node3.getRight() != null) {
            node3.getRight().setParent(node3);
        }

        if (node6.getLeft() != null) {
            node6.getLeft().setParent(node6);
        }
        if (node6.getRight() != null) {
            node6.getRight().setParent(node6);
        }

        if (root1.getLeft() != null) {
            root1.getLeft().setParent(root1);
        }
        if (root1.getRight() != null) {
            root1.getRight().setParent(root1);
        }


        //测试中序线索化
        ThreadedBinaryTreeH threadedBinaryTree = new ThreadedBinaryTreeH();
        threadedBinaryTree.setRoot(root1);
        threadedBinaryTree.threadedNodes();

        //测试: 以 10 号节点测试
        HeroNodeH leftNode = node10.getLeft();
        HeroNodeH rightNode = node10.getRight();
        System.out.println("10 号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10 号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
    }
}

//定义 BinaryTree 二叉树
class ThreadedBinaryTreeH {
    private HeroNodeH root;

    //为实现线索化,需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNodeH pre = null;

    public void setRoot(HeroNodeH root) {
        this.root = root;
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNodeH node = root;
        HeroNodeH pre = null;
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }

        //如果当前结点的右指针指向的是后继结点,就一直输出
        while (node != null) {
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    //重载
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //后序遍历线索化二叉树的方法

    /**
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNodeH node) {
        //如果node==null,不能线索化
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());

        //线索化右子树
        threadedNodes(node.getRight());

        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针,指向前驱节点,pre
            node.setLeft(pre);
            //修改当前节点的指针类型
            node.setLeftType(1);
        }

        //处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点,成为,下一个结点的前驱结点
        pre = node;
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
    public HeroNodeH preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSerash(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNodeH infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSerash(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNodeH postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSerash(no);
        } else {
            return null;
        }
    }

}

class HeroNodeH {
    private int no;
    private String name;
    private HeroNodeH left;
    private HeroNodeH right;
    private HeroNodeH parent;//当前节点的父级节点

    public HeroNodeH getParent() {
        return parent;
    }

    public void setParent(HeroNodeH parent) {
        this.parent = parent;
    }

    //说明
    //1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNodeH(int no, String name) {
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

    public HeroNodeH getLeft() {
        return left;
    }

    public void setLeft(HeroNodeH left) {
        this.left = left;
    }

    public HeroNodeH getRight() {
        return right;
    }

    public void setRight(HeroNodeH right) {
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
    public HeroNodeH preOrderSerash(int no) {
        System.out.println("进入前序遍历查找~");
        //比较是不是
        if (this.no == no) {
            return this;
        }

        HeroNodeH resNode = null;
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
    public HeroNodeH infixOrderSerash(int no) {

        HeroNodeH resNode = null;
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
    public HeroNodeH postOrderSerash(int no) {

        HeroNodeH resNode = null;
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
