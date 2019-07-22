class removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (s.charAt(pos) > s.charAt(i)) pos = i;
            if (count[s.charAt(i) - 'a'] == 0) break;
        }

        return s.substring(pos, pos+1) +
                removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
    }
}