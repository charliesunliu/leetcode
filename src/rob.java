/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class rob {
    public int rob(TreeNode root) {
        //left [with child, without]
        //right[with child, without]
        //root.val +
        if (root == null){
            return 0;
        }

        int[] results = helper(root);

        return Math.max(results[0], results[1]);

    }

    private int[] helper(TreeNode root){
        int[] result = new int[2];
        if (root.left == null && root.right == null){
            result[0] = root.val;
            return result;
        }

        int[] left = new int[2];
        int[] right = new int[2];

        if (root.left != null){
            left = helper(root.left);
        }

        if (root.right != null){
            right = helper(root.right);
        }

        result[0] = left[1] + right[1] + + root.val;
        result[1] = Math.max(Math.max(left[0] + right[0], left[1] + right[1]) , Math.max(left[0] + right[1], left[1] + right[0]));
        System.out.println(result[0] + "-----" + result[1]);
        return result;
    }
}