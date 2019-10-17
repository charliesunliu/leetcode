class minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];



        return result[result.length-1][result[0].length-1];
    }
}