public class longestPalindrome {
    int longest = 0;
    int i_ = 0;
    int j_ = 0;
    int[][] dp;
    public String longestPalindrome(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (helper(s, i, j) && longest < j - i + 1){
                    longest = j-i+1;
                    i_ = i; j_ = j;

                }
            }
        }

        if (j_ <= s.length()){
            return s.substring(i_, j_ + 1);
        }

        return "";
    }
    private boolean helper(String s, int i, int j){
        if (dp[i][j] == 1){
            return true;
        }
        if (s.charAt(i) != s.charAt(j)){
            dp[i][j] = -1;
            return false;
        }

        if (i == j){
            dp[i][j] = 1;
            return true;
        }
        if (j - i == 1){
            if (s.charAt(i) == s.charAt(j)){
                dp[i][j] = 1;
                return true;
            }
            dp[i][j] = -1;
            return false;
        }

        if (s.charAt(i) == s.charAt(j) && helper(s, i + 1, j - 1)){
                dp[i][j] = 1;
                return true;
        }
        dp[i][j] = -1;
        return false;
    }
}
