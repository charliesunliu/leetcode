import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class shortestBridge {
    int[][] directions =
            {
                    {1,0},
                    {-1,0},
                    {0,1},
                    {0,-1}
            };
    public int shortestBridge(int[][] A) {
        int[] start = startPoint(A);
        Queue<int[]> queue = new LinkedList<>();
        coverIland(queue, A, start[0], start[1]);
        int layer = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] currentIndex = queue.poll();
                for (int[] dir : directions){
                    int[] next = {currentIndex[0] + dir[0], currentIndex[1] + dir[1]};
                    if (next[0] < 0 || next[0] >= A.length||next[1] < 0 ||next[1] >= A[0].length){
                        continue;
                    }
                    if (A[next[0]][next[1]] == 1){
                        return layer * -1 - 1;
                    }
                    if (A[next[0]][next[1]] == 0){
                        A[next[0]][next[1]] = layer - 1;
                        queue.offer(next);
                    }
                }
            }
            layer--;
        }
        return -1;
    }
    private int[] startPoint(int[][] A){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                if (A[i][j] == 1){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    private void coverIland(Queue<int[]> queue, int[][] A, int i, int j){
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1){
            return;
        }
        else {
            for (int[] dir : directions){
                queue.offer(new int[]{i,j});
                A[i][j] = -1;
                coverIland(queue, A, i + dir[0], j+dir[1]);
            }
        }
    }
}