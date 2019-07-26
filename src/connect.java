import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class connect {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        root.next = null;

        ArrayDeque<Node> levelOrderQueue = new ArrayDeque<>();
        levelOrderQueue.add(root);
        ArrayList<Node> levelOrder = new ArrayList<>();

        while (!levelOrderQueue.isEmpty()){
            Node temp = levelOrderQueue.poll();
            levelOrder.add(temp);
            if (temp.left != null){
                levelOrderQueue.add(temp.left);
            }
            if (temp.right != null){
                levelOrderQueue.add(temp.right);
            }
        }
        for (Node n : levelOrder){
            System.out.println("-------");
            System.out.println(n.val);
            System.out.println("-------");
        }
        int level = 0;
        int nextNull = 0;
        for (int i = 0; i < levelOrder.size(); i++){
            if (i == nextNull){
                levelOrder.get(i).next = null;
                level++;
                nextNull += Math.pow(2, level);
            }else {
                levelOrder.get(i).next = levelOrder.get(i+1);
            }
        }


        return root;
    }
}