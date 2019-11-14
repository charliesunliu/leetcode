import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class wallsAndGates {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0){
                    ((LinkedList<int[]>) q).add(new int[] {i, j});
                }
            }
        }
        while (!q.isEmpty()){
            int[] coord = q.poll();

            for (int k = 0; k < DIRECTIONS.size(); k++) {
                int i = coord[0] + DIRECTIONS.get(k)[0];
                int j = coord[1] + DIRECTIONS.get(k)[1];
                if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] != Integer.MAX_VALUE){
                    continue;
                }
                rooms[i][j] = 1 + rooms[coord[0]][coord[1]];
                ((LinkedList<int[]>) q).add(new int[] {i,j});
            }
        }
    }
}