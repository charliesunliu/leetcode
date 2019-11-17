class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length < 1){
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right-left)/2;
            if (nums[mid] == target){
                break;
            }
            if (nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if (nums[mid] != target){
            return result;
        }
        left = mid;
        right = nums.length - 1;
        while (left < right){
            int newMid = left + (right - left)/2;
            if (nums[newMid] == target && nums[newMid+1]!= target){
                left = newMid;
                break;
            }
            else if (nums[newMid] > target) {
                right = newMid - 1;
            }
            else {
                left = newMid + 1;
            }
        }
        if (nums[left] != target){
            result[1] = left-1;
        }else {
            result[1] = left;
        }
        right = mid;
        left = 0;
        while (left < right){
            int newMid = left + (right - left)/2;
            if (nums[newMid] != target && nums[newMid+1] == target){
                right = newMid+1;
                break;
            }
            else if (nums[newMid] < target) {
                left = newMid + 1;
            }
            else {
                right = newMid - 1;
            }
        }
        if (nums[right] != target){
            result[0] = right-1;
        }else {
            result[0] = right;
        }
        return result;
    }
}