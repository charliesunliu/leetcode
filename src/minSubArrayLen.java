import java.util.Deque;
import java.util.LinkedList;

class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        long[] subSum = new long[nums.length+1];

        for(int i = 0; i <= nums.length; i++){
            subSum[i+1] = subSum[i] + nums[i];
        }

        int result = -1;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++){
            while (!queue.isEmpty() && subSum[i] - subSum[queue.getFirst()] >= s){
                if (result == -1){
                    result = i - queue.poll();
                }else {
                    result = Math.min(result, i - queue.poll());
                }
            }
            queue.add(i);
        }
        return result;
    }
}