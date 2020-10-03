import java.util.Arrays;

class numMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        int n = stones.length;
        Arrays.sort(stones);
        result[1] = Math.max(stones[n-1] - stones[1] - n + 2, stones[n-2] - stones[0] - n + 2);
        int left = 0;
        for (int right = 0; right < n; right++){
            while (stones[right] - stones[left] + 1 > n){
                left++;
            }
            if (right - left + 1 == n - 1 && stones[right] - stones[left] + 1 == n - 1){
                result[0] = Math.min(result[0], 2);
            }else{
                result[0] = Math.min(result[0], n - (right - left + 1));
            }
        }


        return result;
    }
}