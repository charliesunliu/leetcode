class search {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int r = rotateIndex(nums);
        int left = binarySearch(nums, 0, r-1, target);
        int right = binarySearch(nums, r, nums.length-1,target);

        if (left == right){
            return left;
        }

        return Math.max(left, right);
    }
    private int rotateIndex(int[] nums){

        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right])
            return 0;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[mid+1]){
                return mid+1;
            }
            if (nums[mid] >= nums[left]){
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }


        return 0;
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }
}