public class maxPath {
    public double maxPath(double[][] matrix){
            if (matrix.length == 0){
                return 0;
            }


            int m = matrix.length;
            int n = matrix[0].length;
            double ans = 0;

            for (int c = 1; c < n; c++) {
                for (int r = 0; r < m; r++) {
                    double t = matrix[r][c-1];
                    if (r > 0) {
                        t = Math.max(t, matrix[r-1][c-1]);
                    }
                    if (r + 1 < m){
                        t = Math.max(t, matrix[r+1][c]);
                    }
                    matrix[r][c] = Math.min(t, matrix[r][c]);

                    if (c == n -1)
                        ans = Math.max(ans, matrix[r][c]);
                    }
            }

            return ans;
        }
}