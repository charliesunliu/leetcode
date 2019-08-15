/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class maxDepth {
    public int maxDepth(TreeNode root) {
        return Math.max(maxDepthHelper(root.left, 1), maxDepthHelper(root.right, 1));
    }
    private int maxDepthHelper(TreeNode root,int deepth){
        if(root == null){
            System.out.println();
            return deepth;
        }
        return Math.max(maxDepthHelper(root.left, 1), maxDepthHelper(root.right, 1));
    }
}