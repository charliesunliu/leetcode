import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class minKnightMoves {
    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y== 0){
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int queueSize = 1;
        int steps = 1;
        queue.add(new int[]{0,0});
        visited.add("0,0");
        while (!queue.isEmpty()){

            if (queueSize == 0){
                queueSize = queue.size();
                steps++;
            }
            int[] position = queue.poll();
            queueSize--;
            for (int[] dir : DIRECTIONS){
                int newX = dir[0] + position[0];
                int newY = dir[1] + position[1];

                if (newX == x && newY == y){
                    return steps;
                }

                if (!visited.contains(newX + "," + newY)){
                    queue.add(new int[]{newX, newY});
                    visited.add(newX + "," + newY);
                }
            }
        }
        return steps;
    }
}