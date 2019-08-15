import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SomaxPathSumlution {
    public int maxPathSum(TreeNode root) {
       int[] max= new int[1];
       max[0] = Integer.MIN_VALUE;

       maxTreeSum(root, max);

        return max[0];


    }
    private int maxTreeSum(TreeNode root, int[] max){
        if (root == null){
            max[0] =  Math.max(max[0], 0);
            return 0;
        }

        int left = Math.max(maxTreeSum(root.left, max), 0);
        int right = Math.max(maxTreeSum(root.right, max), 0);

        int treeSum = left + right + root.val;

        max[0] =  Math.max(max[0], treeSum);


        return root.val + Math.max(left, right);
    }
}