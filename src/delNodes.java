import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
class delNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        if (root == null){
            return result;
        }

        for (int i : to_delete){
            set.add(i);
        }

        if (!set.contains(root.val)){
            result.add(root);
        }

        helper(root, set, result);
        return result;
    }
    private void helper(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> result){
        if (root == null){
            return;
        }

        helper(root.left, to_delete, result);
        helper(root.right, to_delete, result);

        if (to_delete.contains(root.val)){
            if (root.left != null && !to_delete.contains(root.left.val)){
                result.add(root.left);
                root.left = null;
            }
            if (root.right != null){
                if(!to_delete.contains(root.right.val)) result.add(root.right);
                root.right = null;
            }
        }
        if (root.left != null && to_delete.contains(root.left.val)){
            root.left = null;
        }
        if (root.right != null && to_delete.contains(root.right.val)){
            root.right = null;
        }
    }
}