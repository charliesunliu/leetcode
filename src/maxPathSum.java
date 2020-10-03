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
//class SomaxPathSumlution {
//    public int maxPathSum(TreeNode root) {
//       int[] max= new int[1];
//       max[0] = Integer.MIN_VALUE;
//
//       maxTreeSum(root, max);
//
//        return max[0];
//
//
//    }
//    private int maxTreeSum(TreeNode root, int[] max){
//        if (root == null){
//            max[0] =  Math.max(max[0], 0);
//            return 0;
//        }
//
//        int left = Math.max(maxTreeSum(root.left, max), 0);
//        int right = Math.max(maxTreeSum(root.right, max), 0);
//
//        int treeSum = left + right + root.val;
//
//        max[0] =  Math.max(max[0], treeSum);
//
//
//        return root.val + Math.max(left, right);
//    }
//}
class maxPathSum {
    public int maxPathSum(TreeNode root) {


        return maxTreeSum(root)[1];
    }
    private int[] maxTreeSum(TreeNode root){
        if (root == null){
            return new int[]{0, Integer.MIN_VALUE};
        }

        int[] left = maxTreeSum(root.left);
        int[] right =maxTreeSum(root.right);

        left[0] = Math.max(left[0], 0);
        right[0] = Math.max(right[0], 0);

        int treeSum = left[0] + right[0] + root.val;


        return new int[] {root.val + Math.max(left[0], right[0]), Math.max(Math.max(left[1],right[1]), treeSum)};
    }
}