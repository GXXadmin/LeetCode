package 数据结构.树.线索化二叉树;

/**
 * User:郭星星
 * Date:2021/6/5
 * Time:21:27
 */
public class 前序线索化二叉树 {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNodeQ root = new HeroNodeQ(1, "tom");
        HeroNodeQ node2 = new HeroNodeQ(3, "jack");
        HeroNodeQ node3 = new HeroNodeQ(6, "smith");
        HeroNodeQ node4 = new HeroNodeQ(8, "mary");
        HeroNodeQ node5 = new HeroNodeQ(10, "king");
        HeroNodeQ node6 = new HeroNodeQ(14, "dim");
        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试中序线索化
        ThreadedBinaryTreeZ threadedBinaryTree = new ThreadedBinaryTreeZ();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以 10 号节点测试
        HeroNodeQ leftNode = node5.getLeft();
        HeroNodeQ rightNode = node5.getRight();
        System.out.println("10 号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10 号结点的后继结点是=" + rightNode); //1

        //当线索化二叉树后，能在使用原来的遍历方法
        //threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
    }
}

//定义 BinaryTree 二叉树
class ThreadedBinaryTreeZ {
    private HeroNodeQ root;

    //为实现线索化,需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNodeQ pre = null;

    public void setRoot(HeroNodeQ root) {
        this.root = root;
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从 root 开始
        HeroNodeQ node = root;
        while (node != null) {
            //循环的找到 leftType == 1 的结点，第一个找到就是 8 结点
            //后面随着遍历而变化,因为当 leftType==1 时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            //输出当前节点
            System.out.println(node);
            node = node.getRight();
        }
    }

    //重载
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //前序遍历线索化二叉树的方法

    /**
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNodeQ node) {
        //如果node==null,不能线索化
        if (node == null) {
            return;
        }

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

        //线索化左子树
        if (node.getLeftType() == 0) {
            threadedNodes(node.getLeft());
        }

        //线索化右子树
        if (node.getRightType() == 0) {
            threadedNodes(node.getRight());
        }

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
    public HeroNodeQ preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSerash(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNodeQ infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSerash(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNodeQ postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSerash(no);
        } else {
            return null;
        }
    }

}

class HeroNodeQ {
    private int no;
    private String name;
    private HeroNodeQ left;
    private HeroNodeQ right;

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

    public HeroNodeQ(int no, String name) {
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

    public HeroNodeQ getLeft() {
        return left;
    }

    public void setLeft(HeroNodeQ left) {
        this.left = left;
    }

    public HeroNodeQ getRight() {
        return right;
    }

    public void setRight(HeroNodeQ right) {
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
    public HeroNodeQ preOrderSerash(int no) {
        System.out.println("进入前序遍历查找~");
        //比较是不是
        if (this.no == no) {
            return this;
        }

        HeroNodeQ resNode = null;
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
    public HeroNodeQ infixOrderSerash(int no) {

        HeroNodeQ resNode = null;
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
    public HeroNodeQ postOrderSerash(int no) {

        HeroNodeQ resNode = null;
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