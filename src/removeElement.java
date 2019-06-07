class removeElement {
    /*
    Q27
    Idea: Use two pointers, one at the beginning one at the end.

    Problem, many edge cases.
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p2 >= p1){ //why p2 >= p1 here? ({1},1)
            while (p2 >= 0 && nums[p2] == val){ // make sure p2 not under 0
                length--;
                p2--;
            }
            if (p2 > p1 && nums[p1] == val){
                length--;
                nums[p1] = nums[p2];
                p2--;
            }
            p1++;
        }

        return length;
    }
}
