class isInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] matrix = new int[s1.length()+1][s2.length()+1];
        if (s1.length()+s2.length() != s3.length()){
            return false;
        }
        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s2.length(); j++){
                if (i == 0){
                    matrix[i][j] = (s3.substring(0,j).equals(s2.substring(0,j))) ? 1 : 0;
                    continue;
                }
                if (j == 0){
                    String t = s3.substring(0,i);
                    String t2 = s1.substring(0,i);
                    matrix[i][j] = (s3.substring(0,i).equals(s1.substring(0,i))) ? 1 : 0;
                    continue;
                }
                // Left is 1
                if (matrix[i][j-1] == 1 && s3.charAt(i+j-1) == s2.charAt(j-1)){
                    matrix[i][j] = 1;
                }
                if (matrix[i-1][j] == 1 && s3.charAt(i+j-1) == s1.charAt(i-1)){
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix[s1.length()][s2.length()] == 1;
    }
}