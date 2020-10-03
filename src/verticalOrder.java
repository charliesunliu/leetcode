import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class verticalOrder {
    int min;
    int max;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        min = 0; max = 0;
        helper(root, 0, map);
        for (int i = min; i <= max; i++){
            result.add(map.get(i));
        }

        return result;
    }
    private void helper(TreeNode root, int position, HashMap<Integer, List<Integer>> map){
        if (root == null){
            return;
        }
        if (map.containsKey(position)){
            map.get(position).add(root.val);
        }else {
            map.put(position, new LinkedList<>());
            map.get(position).add(root.val);
        }
        min = Math.min(position, min);
        max = Math.max(position, max);
        helper(root.left, position - 1, map);
        helper(root.right, position+1, map);
    }
}