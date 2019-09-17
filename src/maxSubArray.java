class maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int reuslt = Integer.MIN_VALUE;
        long currentSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] + currentSum > currentSum){
                currentSum += nums[i];
            }
            else{
                currentSum = nums[i];
            }

            if (currentSum > reuslt){
                reuslt = (int)currentSum;
            }
            if (currentSum < 0){
                currentSum = Integer.MIN_VALUE;
            }

        }
        return reuslt;
    }
}