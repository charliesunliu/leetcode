class findDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length; int n = matrix[0].length;

        int[] result = new int[m * n];
        int[] preResult = new int[m*n];
        boolean reversed = true;
        int index = 0;
        int i = 0;
        int j = 0;
        while (index < result.length){
            int size = 0;
            int i_ = 0;
            int j_ = 0;
            if (j >= n){
                j_ = n - 1;
                i_ = i + 1;
            } else {
                j_ = j;
            }
            while (i_ < m && j_ >= 0){
                preResult[index] = matrix[i_][j_];
                size++;
                index++;
                j_--; i_++;
            }
            if (j >= n){
                i++;
            } else {
                j++;
            }
            if (reversed){
                for (int ri = 0; ri < size; ri++){
                    result[index - 1 - ri] = preResult[index - size + ri];
                }
            } else {
                for (int ri = 0; ri < size; ri++){
                    result[index - size + ri] = preResult[index - size + ri];
                }
            }
            reversed = !reversed;
        }
        return result;
    }
}