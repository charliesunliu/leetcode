class maxAreaOfIsland {
    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==1) {
                    result = Math.max(helper(i, j, grid), result);
                }
            }
        }


        return result;
    }
    private int helper(int i, int j, int[][] grid){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        int result = 0;
        if (grid[i][j] == 1){
            grid[i][j] = -1;
            result++;
            for (int[] pair : directions){
                result += helper(i + pair[0], j + pair[1], grid);
            }
        }

        return result;
    }
}