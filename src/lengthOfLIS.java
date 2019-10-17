class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int[] length = new int[nums.length];
        int allMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++){
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++){
                if (nums[j] <= nums[i]){
                    max = Math.max(max, length[j]);
                }
            }
            length[i] = Math.max(0,max) + 1;
            allMax = Math.max(allMax, length[i]);
        }
        return allMax;
    }
}