import java.util.ArrayList;
import java.util.HashSet;

class lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        dfs(root,p,q,listP,listQ);

        HashSet<Integer> set = new HashSet<>();
        for (TreeNode n : listP){
            set.add(n.val);
        }
        for (int i = 0; i < listP.size(); i++){
            System.out.println("P----" + listP.get(i).val);
        }
        for (int i = 0; i < listQ.size(); i++){
            System.out.println("Q----" + listQ.get(i).val);
        }
        for (int i = listQ.size()-1; i>0;i--){
            if (set.contains(listQ.get(i).val)){
                return listQ.get(i);
            }
        }

        return null;
    }
    private void dfs(TreeNode root, TreeNode p, TreeNode q, ArrayList listP, ArrayList listQ){
        if (root == null){
            return;
        }
        if (listP.size()!=0 && listQ.size()!=0&&listP.get(listP.size()-1).equals(p)&&listQ.get(listQ.size()-1).equals(q)){
            return;
        }
        if (listP.size() == 0 || !listP.get(listP.size()-1).equals(p)){
            listP.add(root);
        }
        if (listQ.size() == 0 || !listQ.get(listQ.size()-1).equals(q)){
            listQ.add(root);
        }
        dfs(root.left,p,q,listP, listQ);
        dfs(root.right,p,q,listP, listQ);
        if (listP.size() == 0 || !listP.get(listP.size()-1).equals(p)){
            listP.remove(listP.size()-1);
        }
        if (listQ.size() == 0 || !listQ.get(listQ.size()-1).equals(q)){
            listQ.remove(listQ.size()-1);
        }
    }
}