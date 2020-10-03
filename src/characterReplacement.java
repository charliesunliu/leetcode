class characterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLength = 0;
        int currentMaxCount = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            currentMaxCount = Math.max(currentMaxCount, ++count[c-'A']);
            int currentChange = i - left + 1 - currentMaxCount;
            if (currentChange <= k){
                maxLength = Math.max(maxLength, i - left + 1);
            } else {
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return maxLength;
    }
}