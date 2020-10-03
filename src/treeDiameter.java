import java.util.LinkedList;

class treeDiameter {
    public int treeDiameter(int[][] edges) {
        LinkedList<Integer>[] adjList = new LinkedList[edges.length+1];
        for (int i = 0; i < edges.length+1; ++i) adjList[i] = new LinkedList<>();
        for (int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int[] nodeAndDistance = dfs(adjList, 0, 0);



        return dfs(adjList, nodeAndDistance[0], nodeAndDistance[0])[1] - 1;

    }
    private int[] dfs(LinkedList<Integer>[] adjList, int node, int previous){
        int farNode = node;
        int distance = 0;
        for (int i = 0; i < adjList[node].size(); i++){
            if (adjList[node].get(i) != previous){
                int[] temp = dfs(adjList, adjList[node].get(i), node);
                if (temp[1] > distance){
                    distance = temp[1];
                    farNode = temp[0];
                }
            }
        }
        return new int[]{farNode, distance+1};
    }
}