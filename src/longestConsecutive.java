import java.util.HashSet;

class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++){
            set.add(nums[i]);
        }

        int longestStreak = 0;

        for (int num : set){
            if (!set.contains(num-1)){
                int current = num;
                int streak = 1;
                while (set.contains(current+1)){
                    streak++;
                    current++;
                }
                longestStreak = Math.max(longestStreak, streak);
            }
        }

        return longestStreak;
    }
}