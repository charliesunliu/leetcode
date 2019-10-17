class minCost {
    public int minCost(int[][] costs) {
        if (costs.length<1){
            return 0;
        }
        int[][] finalCosts = new int[costs.length][3];
        finalCosts[0][0] = costs[0][0];
        finalCosts[0][1] = costs[0][1];
        finalCosts[0][2] = costs[0][2];
        for (int i = 1; i < finalCosts.length; i++){

            finalCosts[i][0] = Math.min(finalCosts[i-1][1], finalCosts[i-1][2]) + costs[i][0];


            finalCosts[i][1] = Math.min(finalCosts[i-1][0], finalCosts[i-1][2]) + costs[i][1];


            finalCosts[i][2] = Math.min(finalCosts[i-1][0], finalCosts[i-1][1]) + costs[i][2];

        }
        return Math.min(finalCosts[costs.length-1][0],Math.min(finalCosts[costs.length-1][1],finalCosts[costs.length-1][2]));
    }
}