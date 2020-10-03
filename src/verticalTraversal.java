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
class verticalTraversal {
    int max = 0;
    int min = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map = new HashMap<>();
        helper(map, root, 0, 0);
        for (int i = min; i <= max; i++){
            TreeMap<Integer,ArrayList<Integer>> levelMap = map.get(i);
            ArrayList<Integer> current = new ArrayList<>();
            for (int j : levelMap.keySet()){
                Collections.sort(levelMap.get(j));
                current.addAll(levelMap.get(j));
            }
            result.add(current);
        }
        return result;
    }
    private void helper(HashMap<Integer, TreeMap<Integer,ArrayList<Integer>>> map, TreeNode root, int position, int level){
        if (root == null){
            return;
        }
        TreeMap<Integer,ArrayList<Integer>> levelMap = map.getOrDefault(position, new TreeMap<Integer,ArrayList<Integer>>());
        ArrayList<Integer> list = levelMap.getOrDefault(level, new ArrayList<>());
        list.add(root.val);
        levelMap.put(level, list);
        map.put(position, levelMap);
        max = Math.max(position, max);
        min = Math.min(position, min);
        helper(map, root.left, position - 1, level+1);
        helper(map, root.right, position + 1, level+1);
    }
}