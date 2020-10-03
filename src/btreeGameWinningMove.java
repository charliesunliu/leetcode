import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class btreeGameWinningMove {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = getTarget(root, x);

        int leftNum = countSubtree(target.left);
        int rightNum = countSubtree(target.right);
        int parentNum = n - leftNum - rightNum;

        if (leftNum > n/2 || rightNum > n/2 || parentNum > n/2){
            return true;
        }

        return false;
    }

    private TreeNode getTarget(TreeNode root, int x){
        if (root == null){
            return null;
        }
        if (root.val == x){
            return root;
        }
        TreeNode left = getTarget(root.left, x);
        TreeNode right = getTarget(root.right, x);
        if (left == null){
            return right;
        }
        return left;
    }

    private int countSubtree(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1+ countSubtree(root.left) + countSubtree(root.right);
    }
}