import java.util.Arrays;

class minMoves2 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long left = 0;
        long right = 0;
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];
        for (int i = 0; i < n; i++){
            leftSum[i] += left;
            rightSum[n - 1 - i] += right;

            left += nums[i];
            right += nums[n - 1 - i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++){
            long diff = Math.abs(leftSum[i] - (long)nums[i] * (long)(i));
            diff += Math.abs(rightSum[i] - ((long)nums[i] * n - i - 1));
            min = Math.min(min, diff);
        }
        return (int) min;
    }
}