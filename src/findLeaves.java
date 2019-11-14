import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class findLeaves {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null){
            return result;
        }
        helper(root);

        return result;
    }
    private int helper(TreeNode root){
        if (root.left == null && root.right == null){
            if (result.size() > 0){
                result.get(0).add(root.val);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                result.add(temp);
            }
            return 1;
        }
        int left = 0;
        if (root.left!=null){
            left = helper(root.left);
        }
        int right = 0;
        if (root.right!=null){
            right = helper(root.right);
        }

        int index = Math.max(left, right);
        if (index >= result.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        } else {
            result.get(index).add(root.val);
        }

        return index+1;
    }
}