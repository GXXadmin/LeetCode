package 数据结构.树;

/**
 * User:郭星星
 * Date:2021/6/4
 * Time:18:14
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();//1,2,4,5,3,6,7
        System.out.println("=================");
        arrBinaryTree.infixOrder();//4,2,5,1,6,3,7
        System.out.println("=================");
        arrBinaryTree.postOrder();//4,5,2,6,7,3,1
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载
    public void preOrder() {
        preOrder(0);
    }

    public void infixOrder() {
        infixOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }

    /**
     * 前序遍历
     *
     * @param index 数组下标
     */
    public void preOrder(int index) {
        if (arr == null && arr.length == 0) {
            System.out.println("数组为空!!!");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);

        //向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        //向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 中序遍历
     *
     * @param index 数组下标
     */
    public void infixOrder(int index) {
        if (arr == null && arr.length == 0) {
            System.out.println("数组为空!!!");
            return;
        }

        //向左递归
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }

        //输出当前元素
        System.out.println(arr[index]);

        //向右递归
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    /**
     * 后序遍历
     *
     * @param index 数组下标
     */
    public void postOrder(int index) {
        if (arr == null && arr.length == 0) {
            System.out.println("数组为空!!!");
            return;
        }

        //向左递归
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        //向右递归
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        //输出当前元素
        System.out.println(arr[index]);
    }
}





