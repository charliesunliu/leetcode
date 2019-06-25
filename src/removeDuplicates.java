/*

-1,0,1,1,2,2,3,3,4,4





 */


class removeDuplicates {
//    public int removeDuplicates(int[] nums) {
//        if(nums.length < 2){
//            return nums.length;
//        }
//        int left = 1;
//        int right = 1;
//
//        int leftPre = nums[0];
//        int rightPre = nums[0];
//
//        while (right < nums.length){
//            if (leftPre >= nums[left]){
//                if (leftPre >= nums[right] || rightPre >= nums[right]){
//                    right++;
//                }else{
//                    nums[left] = nums[right];
//                    rightPre = nums[right];
//                    leftPre = nums[left];
//                    right++;
//                    left++;
//                }
//            }else {
//                leftPre = nums[left];
//                left++;
//                if (left > right){
//                    rightPre = nums[right];
//                    right++;
//                }
//            }
//        }
//        return left;
//    }
public int removeDuplicates(int[] nums) {
    if(nums.length < 2){
        return nums.length;
    }
    int left = 1;
    int right = 1;

    // int leftPre = nums[0];
    // int rightPre = nums[0];

    while (right < nums.length){
        if (nums[left - 1] >= nums[left]){
            if (nums[left - 1] >= nums[right] || nums[right - 1] >= nums[right]){
                right++;
            }else{
                nums[left] = nums[right];
                // rightPre = nums[right];
                // leftPre = nums[left];
                right++;
                left++;
            }
        }else {
            //leftPre = nums[left];
            left++;
            if (left > right){
                right++;
            }
        }
    }
    return left;
}
}