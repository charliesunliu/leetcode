class maxProfitcd {
    public int maxProfitcd(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int[][] results = new int[3][prices.length];
        results[0][0] = - prices[0];
        results[1][0] = 0;
        results[2][0] = 0;

        for (int i = 1; i < prices.length; i++){
            results[0][i] = Math.max(results[0][i-1], results[2][i-1] - prices[i]);
            results[1][i] = Math.max(results[1][i-1], results[0][i-1] + prices[i]);
            results[2][i] = Math.max(Math.max(results[0][i-1], results[1][i-1]), results[2][i-1]);
            System.out.println(results[0][i] + "----" + results[1][i] + "------" + results[2][i]);
        }

        return Math.max(Math.max(results[0][prices.length-1], results[1][prices.length-1]), results[2][prices.length-1]);
    }
}