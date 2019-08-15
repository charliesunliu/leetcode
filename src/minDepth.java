/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class minDepth {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.min(minDepthHelper(root.left, 1), minDepthHelper(root.right, 1));
    }

    private int minDepthHelper(TreeNode root, int n){
        if (root.left == null && root.right == null){
            return n;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null){
            left = minDepthHelper(root.left, n+1);
        }
        if (root.right != null){
            right = minDepthHelper(root.right, n+1);
        }
        return Math.min(left, right);
    }
}