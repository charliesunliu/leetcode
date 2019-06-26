class rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++){
            int currentPos = start;
            int currentVal = nums[currentPos];
            do {
                int nextPos = (currentPos + k) % nums.length;
                int tempVal = currentVal;
                currentVal = nums[nextPos];

                nums[nextPos] = tempVal;

                count++;
                currentPos = (currentPos + k) % nums.length;
            }while (currentPos != start);
        }
        return;
    }
}