class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][9];
        int[][] matrix = new int[9][9];
        int[][] row = new int[9][9];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int num = board[i][j] - '0';
                if(num < 0){
                    continue;
                }
                if (col[j][num-1] == 1){
                    return false;
                } else {
                    col[j][num - 1] = 1;
                }
                if (row[i][num-1] == 1){
                    return false;
                } else {
                    row[i][num-1] = 1;
                }
                int matrixIndex = (i/3)*3 + j/3;
                if (matrix[matrixIndex][num-1] == 1){
                    return false;
                }
                else {
                    matrix[matrixIndex][num-1] = 1;
                }
            }
        }

        return true;
    }
}