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
class pathSumII {
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        System.out.println("leaf");
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> currRes = new ArrayList<>();
        pathSumIIHelper(root, sum, 0, currRes, res);

        return res;
    }
    private void pathSumIIHelper(TreeNode root, int target, int currentSum, ArrayList<Integer> currentRes, List<List<Integer>> res){
        if (root == null){
            return;
        }
        currentSum += root.val;
        currentRes.add(root.val);
        if (root.left == null && root.right == null){
            if (currentSum+root.val == target){

                res.add((List<Integer>) currentRes.clone());

                currentRes.remove(currentRes.size()-1);

                return;
            }
        }

        pathSumIIHelper(root.left, target, currentSum, currentRes, res);
        pathSumIIHelper(root.right, target, currentSum, currentRes, res);

        currentRes.remove(currentRes.size()-1);

        return;
    }




}