import java.util.*;

class findMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n <= 0){
            return result;
        }
        if (n == 1){
            result.add(0);
            return result;
        }
        ArrayList<HashSet<Integer>>  edgesList = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++){
            HashSet<Integer> temp = new HashSet<>();
            edgesList.add(i, temp);
        }

        for (int i = 0; i < edges.length; i++){
            edgesList.get(edges[i][0]).add(edges[i][1]);
            edgesList.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }


        Queue<Integer> leafQ = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (degree[i] == 1){
               leafQ.offer(i);
            }
        }
        while (!leafQ.isEmpty()){
            result = new ArrayList<>();
            int size = leafQ.size();

            for (int i = 0; i < size; i++){
                int current = leafQ.poll();
                result.add(current);
                degree[current]--;

                int next = 0;
                Iterator nextIterator = edgesList.get(current).iterator();
                if (nextIterator.hasNext()){
                    next = edgesList.get(current).iterator().next();
                }else{
                    return result;
                }
                if (degree[next] == 2){
                    leafQ.offer(next);
                }
                edgesList.get(next).remove(current);
                degree[next]--;

            }
        }

        return result;

    }
}