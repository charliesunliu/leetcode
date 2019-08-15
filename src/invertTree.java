/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        invertHelper(root);

        return root;
    }
    private void invertHelper(TreeNode node){
        if (node == null){
            return;
        }

        TreeNode newL = null;
        TreeNode newR = null;
        if (node.left != null){
            newR = new TreeNode(node.left.val);
            newR.left = node.left.left;
            newR.right = node.left.right;
        }
        if (node.right != null){
            newL = new TreeNode(node.right.val);
            newL.left = node.right.left;
            newL.right = node.right.right;
        }

        node.left = newL;
        node.right = newR;

        invertTree(node.left);
        invertTree(node.right);

    }
}