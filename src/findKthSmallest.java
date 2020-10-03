class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
        while (low < high){
            int[]minMax = new int[] {matrix[0][0], matrix[matrix.length - 1][matrix.length - 1]};
            int mid = low + (high - low) / 2;
            count = countLessEqual(matrix, low + (high - low) / 2, minMax);

            if (count == k){
                return mid;
            }
            if (count > k){
                low = minMax[1];
            }
            else{
                high = minMax[0];
            }
        }
        return low;
    }
    private int countLessEqual(int[][] matrix, int mid, int[] minMax){
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix.length && row >= 0){

            if (matrix[row][col] > mid){
                minMax[1] = Math.min(minMax[1], matrix[row][col]);
                row--;
            } else {
                minMax[0] = Math.max(minMax[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}