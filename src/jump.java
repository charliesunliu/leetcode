class jump {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int i = 0;
        int far = 0;
        int nextFar = nums[0];
        int steps = 0;
        while (i < nums.length){
            if(i == far && far == nums.length - 1){
                return steps;
            }
            if (nums[i] + i > far && nums[i] + i > nextFar){
                nextFar = nums[i] + i;
            }
            if (i == far){
                steps++;
                far = nextFar;
            }
            // if (nextFar >= nums.length - 1){
            //     return steps + 1;
            // }
            i++;
        }

        return steps;
    }
}