import java.util.*;





class cloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }

        LinkedList<Node> list = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        Stack<Node> s = new Stack<>();
        s.push(node);
        while (!s.isEmpty()){
            Node tempNode = s.pop();
            if (!map.containsKey(tempNode)){
                Node cloneNode = new Node(tempNode.val, new ArrayList<>());
                map.put(tempNode, cloneNode);
            }
            for (Node n : tempNode.neighbors){
                if (!map.containsKey(n)){
                    s.push(n);
                }
            }
        }

        for (Node n : map.keySet()){
            Node cloneN = map.get(n);
            for (Node nextNode: n.neighbors){
                cloneN.neighbors.add(map.get(nextNode));
            }
        }

        return map.get(node);
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}