import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class pacificAtlantic {
    int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++){
            pacific[i][0] = 1;
            pacificQueue.add(new int[]{i,0});

            atlantic[i][n-1] = 1;
            atlanticQueue.add(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++){
            pacific[0][j] = 1;
            pacificQueue.add(new int[]{0,j});

            atlantic[m-1][j] = 1;
            atlanticQueue.add(new int[]{m-1, j});
        }

        while (!pacificQueue.isEmpty() || !atlanticQueue.isEmpty()){
            int pacificSize = pacificQueue.size();
            int atlanticSize = atlanticQueue.size();

            for (int i = 0; i < pacificSize; i++){
                int[] currentIndex = pacificQueue.poll();
                int ci = currentIndex[0];
                int cj = currentIndex[1];
                for (int[] dir : directions){
                    if (ci + dir[0] >= 0 && ci + dir[0] < m && cj + dir[1] >=0 && cj + dir[1] < n){
                        if (matrix[ci][cj] <= matrix[ci + dir[0]][cj + dir[1]] && pacific[ci + dir[0]][cj + dir[1]] == 0){
                            pacific[ci + dir[0]][cj + dir[1]] = 1;
                            pacificQueue.add(new int[]{ci + dir[0], cj + dir[1]});
                        }
                    }
                }
            }

            for (int i = 0; i < atlanticSize; i++){
                int[] currentIndex = atlanticQueue.poll();
                int ci = currentIndex[0];
                int cj = currentIndex[1];
                for (int[] dir : directions){
                    if (ci + dir[0] >= 0 && ci + dir[0] < m && cj + dir[1] >=0 && cj + dir[1] < n){
                        if (matrix[ci][cj] <= matrix[ci + dir[0]][cj + dir[1]] && atlantic[ci + dir[0]][cj + dir[1]] == 0){
                            atlantic[ci + dir[0]][cj + dir[1]] = 1;
                            atlanticQueue.add(new int[]{ci + dir[0], cj + dir[1]});
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (atlantic[i][j] == 1 && pacific[i][j] == 1){
                    List<Integer> l = new LinkedList<>();
                    l.add(i); l.add(j);
                    result.add(l);
                }
            }
        }
        return result;
    }
}