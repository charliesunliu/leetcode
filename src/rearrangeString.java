class rearrangeString {
    public String rearrangeString(String s, int k) {
        int[] frec = new int[26];
        int[] nextPos = new int[26];
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            frec[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++){

            int c = (findPos(frec, nextPos,i));
            if (c == -1){
                return "";
            }
            buffer.append((char)('a'+ c));
            nextPos[c] = nextPos[c] + k;
            frec[c]--;
        }

        return buffer.toString();
    }

    private int findPos(int[] frec,int[] pos, int currentIndex){
        int max = Integer.MIN_VALUE;
        int curPos = -1;
        for (int j = 0; j < 26; j++){
            if (frec[j] > 0 && frec[j] > max && pos[j] <= currentIndex){
                curPos = j;
                max = frec[j];
            }
        }
        return curPos;
    }
}