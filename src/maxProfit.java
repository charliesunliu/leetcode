class maxProfit {
    public int maxProfit(int[] prices) {
        int high = Integer.MIN_VALUE;
        int highPos = -1;

        int low = Integer.MAX_VALUE;
        int lowPos = -1;

        int profit = 0;


        for(int i = 0; i < prices.length; i++){
//            if (prices[i] > high){
//                high = prices[i];
//                highPos = i;
//            }
            if (prices[i] < low){
                low = prices[i];
                lowPos = i;
            }

            if (i > lowPos){
                profit = Math.max(profit, prices[i] - low);
            }
        }
        return profit;
    }
}