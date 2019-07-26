/*
// Definition for a Node.
*/
import java.util.ArrayDeque;
import java.util.ArrayList;
class connect2 {
    public Node connect(Node root) {

        if (root == null){
            return root;
        }
        root.next = null;

        ArrayDeque<Node> levelOrderQueue1 = new ArrayDeque<>();
        ArrayDeque<Node> levelOrderQueue2 = new ArrayDeque<>();
        levelOrderQueue1.add(root);
        ArrayList<Node> levelOrder = new ArrayList<>();

        while (!levelOrderQueue1.isEmpty() || !levelOrderQueue2.isEmpty()){
            if (levelOrderQueue1.isEmpty()){
                while (!levelOrderQueue2.isEmpty()){
                    Node temp = levelOrderQueue2.poll();
                    levelOrder.add(temp);
                    if (temp.left != null){
                        levelOrderQueue1.add(temp.left);
                    }
                }
                levelOrder.add(null);
            }else {
                while (!levelOrderQueue1.isEmpty()){
                    Node temp = levelOrderQueue1.poll();
                    levelOrder.add(temp);
                    if (temp.left != null){
                        levelOrderQueue2.add(temp.left);
                    }
                }
                levelOrder.add(null);
            }
        }
        for (int i = 0; i < levelOrder.size(); i++){
            if (levelOrder.get(i) == null){
                continue;
            }else {
                levelOrder.get(i).next = levelOrder.get(i+1);
            }
        }

        return root;
    }
}