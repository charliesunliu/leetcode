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
class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        StringBuffer cur = new StringBuffer();
        cur.append(root.val);
        pathHelper(root.left, res, cur);
        pathHelper(root.right, res, cur);
        if (root.right == null && root.left == null){
            res.add(cur.toString());
        }
        return res;
    }
    private void pathHelper(TreeNode root, List<String> res, StringBuffer current){
        if (root == null){
            return;
        }
        int delete = current.length();
        if (root.right == null && root.left == null){
            current.append("->");current.append(root.val);
            res.add(current.toString());
            current.delete(delete, current.length());
            return;
        }
        current.append("->");current.append(root.val);
        pathHelper(root.left, res, current);
        pathHelper(root.right, res, current);
        current.delete(delete, current.length());
    }
}