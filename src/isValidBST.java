/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root.left, root.val, Long.MIN_VALUE) && helper(root.right, Long.MAX_VALUE, root.val);
    }
    private boolean helper(TreeNode root, long up, long bot){
        if (root == null){
            return true;
        }
        if (root.val >= up || root.val <= bot){
            return false;
        }
        return helper(root.left, root.val, bot) && helper(root.right, up, root.val);
    }
}