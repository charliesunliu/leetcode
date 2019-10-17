class getMoneyAmount {
    public int getMoneyAmount(int n) {

        int[][] matrix = new int[n+1][n+1];
        return gmaHelper(matrix, 1, n);
    }
    private int gmaHelper(int[][] matrix, int left, int right){
        System.out.println(left+"----"+right);
        if(left >= right) return 0;
        if(matrix[left][right] != 0) return matrix[left][right];
        if (right - left == 1){
            matrix[left][right] = left;
            return left;
        }
        if (right - left == 2){
            matrix[left][right] = left+1;
            return left + 1;
        }
        int min = Integer.MAX_VALUE;

        int index = left;
        for (index = left; index < right; index++){
            int max = index + Math.max(gmaHelper(matrix, left, index-1), gmaHelper(matrix, index+1, right));
            min = Math.min(min, max);
        }
        matrix[left][right] = min;
        return min;
    }
}