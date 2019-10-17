import java.util.Arrays;

class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        long min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;

            while (left < right){
                int current = nums[i] + nums[left] + nums[right];
                if (Math.abs(current - target) > Math.abs(min - target) && current >= target){
                    return (int)min;
                }
                if (current == target){
                    return target;
                }
                if (current > target){
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(current - target) < Math.abs(min - target)){
                    min = current;
                }
            }
        }
        return (int)min;
    }
}