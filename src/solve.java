class solve {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0){
            return;
        }
        for (int i = 0; i < board.length; i++){
            helper(i, 0, board);
            helper(i, board[0].length - 1 , board);
        }
        for (int j = 0; j < board[0].length; j ++){
            helper(0, j, board);
            helper(board.length - 1, j , board);
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Q'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void helper(int i, int j, char[][] board){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        if (board[i][j] == 'O'){
            board[i][j] = 'Q';
            helper(i - 1,j ,board);
            helper(i + 1,j ,board);
            helper(i,j - 1 ,board);
            helper(i,j + 1 ,board);
        }
    }
}