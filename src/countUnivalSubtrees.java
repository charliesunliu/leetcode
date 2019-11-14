import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null){
            return result;
        }
        helper(root);
        return result;
    }
    private boolean helper(TreeNode root){
        boolean left = root.left == null || helper(root.left) && root.left.val == root.val;
        boolean right =root.right == null || helper(root.right) && root.right.val == root.val;

        if (left && right){
            result++;
            return true;
        }
        return false;

    }
}