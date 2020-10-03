import java.util.ArrayList;
import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        goLeft();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = s.pop();
        if (res.right != null){
            s.push(res.right);
            goLeft();
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    private void goLeft(){
        while (s.peek().left != null){
            s.push(s.peek().left);
        }
    }


//    private ArrayList<Integer> list;
//    private int pointer;
//    public BSTIterator(TreeNode root) {
//        list = new ArrayList<>();
//        helper(root, list);
//        pointer = 0;
//    }
//    private void helper(TreeNode root, ArrayList<Integer> list){
//        if (root == null){
//            return;
//        }
//        helper(root.left, list);
//        list.add(root.val);
//        helper(root.right, list);
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        int result = list.get(pointer);
//        pointer++;
//        return result;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return pointer != list.size();
//    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */