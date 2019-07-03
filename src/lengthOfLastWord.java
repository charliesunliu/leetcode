public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' '){
            i--;
        }
        while (i >=0){
            if (s.charAt(i) != ' '){
                len++;
            }else {
                return len;
            }
            i--;
        }
        return len;
    }
}
