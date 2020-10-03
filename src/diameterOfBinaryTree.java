/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class diameterOfBinaryTree {
    int RESULT = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        helper(root, -1);
        return RESULT;
    }
    private int helper(TreeNode root, int result){
        if (root == null){
            return result;
        }
        result = result+1;
        int left = helper(root.left, 0);
        int right = helper(root.right, 0);
        RESULT = Math.max(RESULT, left+right);
        return Math.max(left,right)+1;
    }
}