public class firstUniqChar {
    public int firstUniqChar(String s) {
        int[] charList = new int[26];

        for (int i = 0; i < s.length(); i++){
            int ascii = (int) s.charAt(i) - 97;
            charList[ascii]++;
        }
        for (int i = 0; i < s.length(); i++){
            int ascii = (int) s.charAt(i) - 97;
            if (charList[ascii] == 1){
                return i;
            }
        }

        return -1;
    }
}
