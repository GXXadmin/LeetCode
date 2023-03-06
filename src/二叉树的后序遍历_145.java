import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历_145 {
    public static void main(String[] args) {
        Solution_145 solution_145 = new Solution_145();
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,null);
        TreeNode treeNode1 = new TreeNode(1,null,treeNode2);
        List<Integer> list = solution_145.postorderTraversal(treeNode1);
        list.forEach(System.out::println);
    }
}
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack_pre = new Stack<>();
        Stack<TreeNode> stack_next = new Stack<>();
        stack_pre.push(root);

        while (!stack_pre.isEmpty()){
            root = stack_pre.pop();
            stack_next.push(root);
            if (root.left != null){
                stack_pre.push(root.left);
            }
            if (root.right != null){
                stack_pre.push(root.right);
            }
        }
        while (!stack_next.isEmpty()){
            root = stack_next.pop();
            list.add(root.val);
        }
        return list;
    }
}
