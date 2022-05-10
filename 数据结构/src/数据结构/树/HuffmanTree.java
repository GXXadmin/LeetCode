package 数据结构.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User:郭星星
 * Date:2021/6/8
 * Time:19:37
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }

    //前序遍历方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树,无法遍历");
        }
    }

    //创建哈夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        // 1. 遍历 arr 数组
        // 2. 将 arr 的每个元素构成成一个 Node
        // 3. 将 Node 放入到 ArrayList 中
        List<Node> nodes = new ArrayList<Node>();
        //使用增强for循环向list中添加arr,及,将int转化为Node
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);

            //取出根节点value最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构建新二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //删除处理过的树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent添加到nodes中
            nodes.add(parent);
        }

        return nodes.get(0);

    }


}

//创建节点类
class Node implements Comparable<Node> {
    int value;//节点权值
    Node left;//左节点
    Node right;//右节点

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //构造函数
    public Node(int value) {
        this.value = value;
    }

    //重写
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}









