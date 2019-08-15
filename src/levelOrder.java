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
class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        levelHelper(level, res, root);
        return res;


    }
    private void levelHelper(int level, List<List<Integer>> res, TreeNode root){
        if (root == null){
            return;
        }
        if (res.size() <= level){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            res.add(l);
        }else {
            res.get(level).add(root.val);
        }
        levelHelper(level+1, res, root.left);
        levelHelper(level+1, res, root.right);

        return;

    }

}