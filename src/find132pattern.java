import java.sql.Array;
import java.util.Arrays;

class find132pattern {
    public boolean find132pattern(int[] nums) {
//        int[] sorted = nums.clone();
//
//        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                for (int k = nums.length - 1; k > j; k--){
                    if (nums[i] < nums[j] && nums[k] > nums[i] && nums[k] < nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}