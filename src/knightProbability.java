import java.util.Arrays;

class knightProbability {
    private int[][] steps = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] map = new double[N][N];
        map[r][c] = 1;
        for (int k = 0; k < K; k++){
            double[][] nextMap = new double[N][N];
            for (int i =0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (map[i][j] == 0){
                        continue;
                    }
                    for (int[] step: steps){
                        int ci = i + step[0];
                        int cj = j + step[1];
                        if (ci >= 0 && ci < N && cj >= 0 && cj <= N){
                            nextMap[ci][cj] += map[i][j]/8;
                        }
                    }
                }
            }
            map = nextMap;
        }

        double ans = 0;
        for (double[] doubles: map){
            for (double d : doubles){
                ans+=d;
            }
        }
        return ans;
    }
}