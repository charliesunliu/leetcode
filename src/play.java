class play {

    int[][] directinos = {{1,1},{-1,1},{-1,-1},{1,-1}};
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    seraching(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void seraching(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
            return;
        }
        for (int k = 0; k < 4; k++){
            grid[i][j] = '0';
            seraching(grid, i + directinos[k][0], j + directinos[k][1]);
        }
    }
}