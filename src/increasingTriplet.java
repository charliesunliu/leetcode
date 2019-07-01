public class increasingTriplet {


    public boolean increasingTriplet(int[] nums) {
        int s = Integer.MAX_VALUE;
        int sPos = 0;
        int m = Integer.MAX_VALUE;
        int mPos = 0;



        for (int i = 0; i < nums.length; i++){
            if (nums[i] > s && nums[i] > m){
                return true;
            }
            if (nums[i] < s){
                s = nums[i];
                sPos = i;
            }
            if (nums[i] <= m && nums[i] > s && sPos > i){
                m = nums[i];
                mPos = i;
            }
        }

        return false;
    }

}
