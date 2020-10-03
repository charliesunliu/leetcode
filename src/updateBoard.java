public class updateBoard {
    int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        setMap(board, click);
        return board;
    }

    private int countMineAround(char[][] board, int[] click) {

        int res = 0;
            for(
        int[] dir :DIRECTIONS)

        {
            int Y = click[0] + dir[0];
            int X = click[1] + dir[1];
            if (Y >= 0 && Y < board.length && X >= 0 && X < board.length) {
                if (board[Y][X] == 'M') {
                    res++;
                }
            }
        }
            return res;
    }

    private void setMap(char[][] board, int[] click){
        if(click[0] >= 0 && click[0] < board.length && click[1] >= 0 && click[1] < board.length){
            if(board[click[0]][click[1]] != 'E'){
                return;
            }
            int mines = countMineAround(board, click);
            if(mines > 0){
                board[click[0]][click[1]] = (char)(mines + '0');
            } else{
                board[click[0]][click[1]] = 'B';
                for(int[] dir : DIRECTIONS){
                    int Y = click[0] + dir[0];
                    int X = click[1] + dir[1];
                    setMap(board, new int[]{Y,X});
                }
            }
        }

    }
}
