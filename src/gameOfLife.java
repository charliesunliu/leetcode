class gameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                int nb = neighbours(board, i, j);
                if (nb < 2 && board[i][j] == 1) board[i][j] = -1;
                if (nb == 3 & board[i][j] == 0) board[i][j] = 2;
                if (nb > 3 && board[i][j] == 1) board[i][j] = -1;
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }

    }
    private int neighbours(int[][] board, int i, int j){
        int nb = 0;
        for (int i_ = -1; i_ <= 1; i_++){
            for(int j_ = -1; j_ <=1; j_++){
                if (i_ == 0 && j_ == 0) continue;
                if (i+i_ >= 0 && i+i_ < board.length && j+j_ >= 0 && j+j_ < board[i].length){
                    if (Math.abs(board[i+i_][j+j_]) == 1){
                        nb++;
                    }
                }
            }
        }

        return nb;
    }
}