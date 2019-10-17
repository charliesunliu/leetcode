class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] numOfCoins = new int[amount+1];

        for (int i = 1; i < amount+1; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] == 0){
                    numOfCoins[i] = 1;
                    continue;
                }
                if (i - coins[j] >= 0 && numOfCoins[i - coins[j]] != 0){
                    if (numOfCoins[i] == 0){
                        numOfCoins[i] = numOfCoins[i - coins[j]] + 1;
                    } else {
                        numOfCoins[i] = Math.min(numOfCoins[i - coins[j]] + 1, numOfCoins[i]);
                    }
                }
            }
        }


        if (numOfCoins[amount] == 0){
            return -1;
        }
        return numOfCoins[amount];
    }
}