/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class subtreeWithAllDeepest {
    int maxLevel = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        levelHelper(root, 1);
        return answer(root, 1);
    }
    private void levelHelper(TreeNode root, int level){
        if (root == null){
            return;
        }
        if (level > maxLevel){
            maxLevel = level;
        }
        levelHelper(root.left, level + 1);
        levelHelper(root.right, level + 1);
    }
    private TreeNode answer(TreeNode root, int level){
        if (root == null || level == maxLevel){
            return root;
        }
        TreeNode L = answer(root.left, level + 1);
        TreeNode R = answer(root.right, level + 1);
        if (L != null && R != null) return root;
        if (L != null) return L;
        if (R != null) return R;

        return null;
    }
}