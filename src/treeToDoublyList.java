/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class treeToDoublyList {
    Node last;
    Node first;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void helper(Node root){
        if (root == null){
            return;
        }
        helper(root.left);

        if (last == null){
            last = root;
            first = root;
        } else {
            last.right = root;
            root.left = last;
            last = root;
        }

        helper(root.right);
    }
}