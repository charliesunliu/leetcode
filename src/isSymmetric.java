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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return isSymmetricHelper(root.left, root.right);

    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if ((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if (left == null && right == null){
            return true;
        }
        if (left.val != right.val){
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}