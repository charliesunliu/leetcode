class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] squareSize = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                squareSize[i][j] = matrix[i][j]-48;
                max = Math.max(max, squareSize[i][j]);
            }
        }
        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (squareSize[i][j] == 1){
                    squareSize[i][j] = Math.min(Math.min(squareSize[i-1][j],squareSize[i][j-1]),squareSize[i-1][j-1]) + 1;
                    max = Math.max(max, squareSize[i][j]);
                }
            }
        }
        return max*max;
    }
}