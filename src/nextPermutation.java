import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

class nextPermutation {
    public void nextPermutation(int[] nums) {

        for(int i = nums.length - 1; i > 0; i--){
            if (nums[i] <= nums[i-1]){
                continue;
            }else {
                int min = nums[i];
                int minIndex = i;
                for (int j = i; j < nums.length; j++){
                    if (nums[j] > nums[i-1] && min > nums[j]){
                        min = nums[j];
                        minIndex = j;
                    }
                }
                nums[minIndex] = nums[i-1];
                nums[i-1] = min;
                Arrays.sort(nums,i, nums.length);
                return;
            }
        }
        for(int i = 0; i < nums.length / 2; i++)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}