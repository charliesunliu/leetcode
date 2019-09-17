import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class findMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<HashSet<Integer>>  edgesList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            HashSet<Integer> temp = new HashSet<>();
            edgesList.add(i, temp);
        }
        for (int i = 0; i < edges.length; i++){
            edgesList.get(edges[i][0]).add(edges[i][1]);
            edgesList.get(edges[i][1]).add(edges[i][0]);
        }



        for (int i = 0; i < edgesList.size(); i++){
            if (edgesList.get(i).size() == 1){
               
            }
        }



    }
}