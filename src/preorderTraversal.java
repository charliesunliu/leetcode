import java.util.*;
import java.io.Serializable;

class TreeNode implements Serializable{
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
    }

class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()){
            TreeNode temp = s.pop();
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
            result.add(temp.val);
        }
        return result;
    }
}