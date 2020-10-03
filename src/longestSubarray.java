import java.util.ArrayDeque;

class longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> largest = new ArrayDeque<>();
        ArrayDeque<Integer> smallest = new ArrayDeque<>();
        int result = 0;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++){
            while (!largest.isEmpty() && nums[i] > nums[largest.getFirst()]){
                largest.removeFirst();
            }
            largest.addFirst(i);
            while (!smallest.isEmpty() && nums[i] < nums[smallest.getFirst()]){
                smallest.removeFirst();
            }
            smallest.addFirst(i);

            while (!largest.isEmpty() && !smallest.isEmpty() && Math.abs(nums[largest.getLast()] - nums[smallest.getLast()]) > limit){
                if (largest.getLast() < smallest.getLast()){
                    lastIndex = largest.removeLast();
                } else if(largest.getLast() > smallest.getLast()){
                    lastIndex = smallest.removeLast();
                } else {
                    lastIndex = smallest.removeLast();
                    largest.removeLast();
                }
            }
            result = Math.max(result, i - lastIndex + 1);
        }

        return result;
    }
}