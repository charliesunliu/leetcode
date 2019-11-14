class closedIsland {
    public int closedIsland(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0 && helper(grid, i , j)){
                    result++;
                }
            }
        }
        return result;
    }
    private boolean helper(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }
        if (grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;

        boolean top = helper(grid, i - 1, j);
        boolean bot = helper(grid, i + 1, j);
        boolean left = helper(grid, i, j - 1);
        boolean right = helper(grid, i, j + 1);


        return top &&
                bot &&
                left &&
                right;
    }
}

        [0,0,1,1,0,1,0,0,1,0],
        [1,1,0,1,1,0,1,1,1,0],
        [1,0,1,1,1,0,0,1,1,0],
        [0,1,1,0,0,0,0,1,0,1],
        [0,0,0,0,0,0,1,1,1,0],
        [0,1,0,1,0,1,0,1,1,1],
        [1,0,1,0,1,1,0,0,0,1],
        [1,1,1,1,1,1,0,0,0,0],
        [1,1,1,0,0,1,0,1,0,1],
        [1,1,1,0,1,1,0,1,1,0]