/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode result = helper(nums, 0, nums.length-1);
        return result;
    }
    private TreeNode helper(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int midIndex = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[midIndex]);

        root.left = helper(nums, left, midIndex-1);
        root.right = helper(nums, midIndex + 1, right);

        return root;
    }
}