import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历_144 {
    public static void main(String[] args) {

    }
}




class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return list;
    }
}
