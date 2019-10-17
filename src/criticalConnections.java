import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class criticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> ajList = new ArrayList<>();

        int[] disc = new int[n];
        int[] min  = new int[n];
        int[] time = new int[1];
        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++){
            ajList.add(new ArrayList<>());
        }

        for (List l : connections){
            int left = (int)l.get(0);
            int right = (int)l.get(1);
            ajList.get(left).add(right);
            ajList.get(right).add(left);
        }
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, min, ajList, i, time, result);
            }
        }


        for (List l : connections){
            int left = (int)l.get(0);
            int right = (int)l.get(1);
            if (min[left] > min[right]){
                result.add(l);
            }
        }

        return result;
    }

    private void dfs(int i, int[] disc, int[] min, List<List<Integer>> ajList, int pre, int[] time, List<List<Integer>> res){

        if (disc[i] == -1){
            disc[i] = time[0];
            min[i] = time[0];
            time[0]++;
        }
        List<Integer> connectTo = ajList.get(i);
        for (int j = 0; j < connectTo.size(); j++){
            if (connectTo.get(j) == pre) {
                continue; // if parent vertex, ignore
            }

            if (disc[connectTo.get(j)] == -1){
                dfs(connectTo.get(j), disc, min, ajList, i, time, res);
                min[i] = Math.min(min[i], min[connectTo.get(j)]);
                if (min[connectTo.get(j)] > disc[i]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(connectTo.get(j), i));
                }
            } else {
                min[i] = Math.min(min[i], min[connectTo.get(j)]);
            }

        }
    }
}