class numSquares {
    public int numSquares(int n) {
        if(n <= 3){
            return n;
        }
        int[] res = new int[n+1];

        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        for (int i = 4; i <= n; i++){

            int square = 1;
            int min = Integer.MAX_VALUE;
            if (i == 11){
                System.out.println(1111);
            }
            while (i - Math.pow(square,2) >= 0){
                if (min > res[i - square*square] + 1){
                    min = res[i - square*square] + 1;
                }
                res[i] = min;
                square++;
            }
        }

        return res[n];
    }
}