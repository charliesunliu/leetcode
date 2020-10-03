class superEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] levels = new int[N+1][K+1];
        int moves = 0;
        while (levels[moves][K] < N){
            moves++;
            for (int i = 1; i <= K; i++){
                levels[moves][i] = levels[moves - 1][i-1] + levels[moves-1][i] + 1;
            }
        }

        return moves;
    }
}