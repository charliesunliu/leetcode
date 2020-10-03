import java.util.*;

class slidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = Arrays.deepToString(board);
        int M = board.length, N = board[0].length;

        State start = new State();
        int[][] startBoard = new int[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                startBoard[i][j] = i + j;
            }
        }
        start.board = startBoard; start.i = M - 1; start.j = N - 1;
        Queue<State> queue = new LinkedList();
        Set<String> visited = new HashSet();
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(start);
        visited.add(Arrays.deepToString(start.board));
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                State cur = queue.poll();
                int[][] curBoard = cur.board;
                if (Arrays.deepToString(cur.board).equals(target)) return steps;
                int i = cur.i;
                int j = cur.j;
//                int m = i/N, n = i % N;
                for (int[] move : moves) {
                    int mt = i + move[0], nt = j + move[1];
                    if (mt < 0 || mt >= M || nt < 0 || nt >= N) continue;
                    State nxt = swap(cur,mt,nt);
                    if (visited.contains(nxt)) continue;
                    queue.add(nxt);
                    visited.add(Arrays.deepToString(nxt.board));
                }
            }
            steps++;
        }
        return -1;
    }

    private State swap(State s, int m, int n) {
        State newS = new State();
        int[][] newBoard = new int[s.board.length][s.board[0].length];
        for(int x=0; x<newBoard.length; x++){
            for(int y=0; y<newBoard[x].length; y++){
                newBoard[x][y]=s.board[x][y];
            }
        }

        newBoard[s.i][s.j] = newBoard[m][n];
        newBoard[m][n] = 0;

        newS.board = newBoard;
        newS.i = m;
        newS.j = n;

        return newS;
    }

    class State{
        int[][] board;
        int i;
        int j;
    }
}