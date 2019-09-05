import java.util.Arrays;

class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if (target <= 0){
            return 0;
        }
        Arrays.sort(nums);
        int[] combs = new int[target + 1];
        combs[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                if (nums[j] > i){
                    break;
                }
                combs[i] = combs[i - nums[j]]+combs[i];
            }
        }

        return combs[target];
    }
}