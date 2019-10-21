import java.util.*;

class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int left = i+1; int right = nums.length-1;
            while (left < right){

                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]);
                    result.add(temp);
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++; right--;
                }else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else {
                    left++;
                }
            }
            while (i < nums.length-2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }
}