class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int one = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                one = 1;
            }
            if (nums[i] < 1 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        if (one == 0){
            return 1;
        }
        for (int i = 0; i < n; i++){
            int currentNum = Math.abs(nums[i]);
            int currentNumIndex = currentNum - 1;
            if (currentNum >= n){
                continue;
            }
            nums[currentNumIndex] = Math.min(nums[currentNumIndex], -currentNum);
        }
        System.out.println(nums.toString());
        for (int i = 0; i < n; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}