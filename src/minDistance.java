class minDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0){
            return Math.max(word1.length(), word2.length());
        }
        int[][] map = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <= word1.length(); i++){
            map[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++){
            map[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++){
                int current = Integer.MAX_VALUE;
                if (word1.charAt(i-1) == word2.charAt((j-1))){
                    current = Math.min(current, map[i-1][j-1]);
                }else {
                    current = Math.min(current, map[i-1][j-1]+1);
                }

                map[i][j] = Math.min(current, Math.min(map[i-1][j] + 1, map[i][j-1] + 1));

            }
        }

        return map[word1.length()][word2.length()];
    }
}