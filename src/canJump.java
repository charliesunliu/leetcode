class canJump {
    public boolean canJump(int[] nums) {
        int far = -1;
        for (int i = 0; i < nums.length; i++){
            far = Math.max(far, nums[i] + i);
            if (far >= nums.length - 1){
                return true;
            }
            if (far == i){
                return false;
            }
        }

        return false;
    }
//    public boolean canJump(int[] nums) {
//        int[] nums_ = new int[nums.length];
//
//
//        return canJumpHelper(nums, nums_, 0);
//    }
//    private boolean canJumpHelper(int[] nums, int[] nums_, int pos){
//
//        if (pos == nums.length - 1){
//            return true;
//        }
//        if (pos < 0 || pos >= nums.length || nums_[pos] == 1){
//            return false;
//        }
//
//        nums_[pos] = 1;
//
//        return canJumpHelper(nums, nums_, pos+nums[pos]) || canJumpHelper(nums, nums_, pos - nums[pos]);
//    }
}