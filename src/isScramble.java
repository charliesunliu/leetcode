import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class isScramble {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s1)){
            return true;
        }
        if (s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;


        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
//            if (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
//                return true;
//            }
//            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))){
//                return true;
//            }
        }



        return false;
    }
//    private List<String> isScrambleHelper(String s, HashSet<String> set){
//        if (set.contains(s)){
//            return null;
//        }else {
//            set.add(s);
//            for (int i = 1; i < left.length(); i++){
//                isScrambleHelper(left.substring(i, left.length())+left.substring(0,1), right, set);
//            }
//            for (int i = 1; i < right.length(); i++){
//                isScrambleHelper(right.substring(i, right.length())+right.substring(0,1), right, set);
//            }
//        }
//    }
}