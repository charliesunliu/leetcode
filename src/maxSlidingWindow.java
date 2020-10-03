import java.util.Deque;
import java.util.LinkedList;

class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if(n == 0){
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++){
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        result[0] = nums[dq.getFirst()];
        int ri = 1;
        for (int i = k; i < nums.length; i++){
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if (dq.getFirst() < i - k + 1){
                dq.removeFirst();
            }
            result[ri] = nums[dq.getFirst()];
            ri++;
        }
        return result;
    }
}