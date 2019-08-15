/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.right == null && root.left == null && sum == 0){
            return true;
        }
        System.out.println(root.val);
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum - root.val);
    }
}