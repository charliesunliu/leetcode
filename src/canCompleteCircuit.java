class canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int currentPos = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length * 2; i++){
            if (currentGas < 0){
                start = i % gas.length;
                currentGas = 0;
            }

            currentGas += gas[currentPos];
            currentGas -= cost[currentPos];
            currentPos = (currentPos + 1) % gas.length;

            if (start == currentPos && currentGas >= 0){
                return start;
            }
        }
        return -1;
    }
}