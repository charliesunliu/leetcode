class climbStairs {
    public int climbStairs(int n) {
        if (n <= 0){
            return 0;
        }

        int[] stairs = new int[n];
        stairs[0] = 1;

        for (int i = 0; i < n; i++) {
            if (i + 1 < n){
                stairs[i+1] += stairs[i];
            }
            if (i+2<n){
                stairs[i+2] += stairs[i];
            }
        }
        return stairs[n-1];
    }
}