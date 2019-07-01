class findDuplicate {
    public int findDuplicate(int[] nums) {
        /*
        This one starts with
        int slow = nums[0];
        int fast = nums[nums[0]];
        Did not hit any edge case, but looks bad, can you think a better way?
         */
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;

    }
}