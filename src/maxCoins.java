import javax.rmi.ssl.SslRMIClientSocketFactory;

class maxCoins {
    public int maxCoins(int[] nums) {
        int[][] map = new int[nums.length + 2][nums.length + 2];
        for (int i = 1; i <= nums.length; i++){
            map[i][i] = nums[i-1];
        }
        map[0][0] = map[nums.length+1][nums.length+1] = 1;
        int m = dp(map, 0, nums.length+1,0);
        return m;
    }
    private int dp(int[][] map, int left, int right, int val){
        if (left + 1 == right) return 0;
        if (map[left][right] != 0){
            return map[left][right];
        }
        int max = 0;
        for (int i = left+1; i < right; i++){
            int temp = map[i][i] * map[left][left] * map[right][right] + dp(map, left, i, 0) + dp(map, i, right, 0);
            max = Math.max(max, temp);
        }
        map[left][right] = max + val;
        return map[left][right];
    }
}