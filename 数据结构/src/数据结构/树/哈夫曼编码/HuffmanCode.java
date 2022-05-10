package 数据结构.树.哈夫曼编码;

import java.util.*;

/**
 * User:郭星星
 * Date:2021/6/8
 * Time:21:17
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<NodeData> nodes = getnodes(contentBytes);
        System.out.println("nides=" + nodes);

        //测试
        System.out.println("哈夫曼树遍历!!!");
        NodeData Tree = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        Tree.preOrder();

    }

    //前序遍历
    private void preOrder(NodeData root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树,无法遍历!!!");
        }
    }

    private static List<NodeData> getnodes(byte[] bytes) {
        ArrayList<NodeData> nodes = new ArrayList<NodeData>();

        //遍历bytes,统计每一个字符出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转化为一个Node对象,并并加入到nides中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new NodeData(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    //通过List创建对应的哈夫曼树
    private static NodeData createHuffmanTree(List<NodeData> nodes) {
        while (nodes.size() > 1) {
            //排序,从小到大
            Collections.sort(nodes);
            //取出最小
            NodeData LeftNode = nodes.get(0);
            NodeData RightNode = nodes.get(1);

            //创建父级节点
            NodeData parent = new NodeData(null,LeftNode.weight+RightNode.weight);
            //加入
            parent.left = LeftNode;
            parent.right = RightNode;

            //删除
            nodes.remove(LeftNode);
            nodes.remove(RightNode);

            //父级节点加入nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }


}

//创建Node,存放数据和权值
class NodeData implements Comparable<NodeData> {
    Byte data;//存放数据(字符本身),比如'a'=>'97',' '=>32
    int weight;//权值
    NodeData left;
    NodeData right;

    public NodeData(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(NodeData o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

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

}






















