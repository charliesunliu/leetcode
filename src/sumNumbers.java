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
class sumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        ArrayList<String> res = new ArrayList<>();
        StringBuffer str = new StringBuffer();

        sumHelper(res, str, root);

        int result = 0;
        for (String s : res){
            result += Integer.parseInt(s);
        }
        return result;
    }
    private void sumHelper(ArrayList res, StringBuffer str, TreeNode root){
        if (root.left == null && root.right == null){
            str.append(root.val);
            res.add(str.toString());
            str.deleteCharAt(str.length()-1);
            return;
        }
        str.append(root.val);
        if (root.left!=null){
            sumHelper(res, str, root.left);
        }
        if (root.right != null){
            sumHelper(res, str, root.right);
        }
        str.deleteCharAt(str.length()-1);
        return;
    }
}