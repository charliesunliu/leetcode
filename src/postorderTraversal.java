import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        postHelper(l, root);

        return l;
    }

    private void postHelper(List l, TreeNode root){
        if (root == null){
            return;
        }
        postHelper(l, root.left);
        postHelper(l, root.right);
        l.add(root.val);
        return;
    }
}