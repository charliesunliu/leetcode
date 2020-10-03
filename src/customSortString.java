import java.util.*;
import java.util.stream.IntStream;

class customSortString {
    public String customSortString(String S, String T) {
        int[] chars = new int[26];
        for (int i = 0; i < T.length(); i++){
            chars[T.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            char currentChar = S.charAt(i);
            while (chars[currentChar - 'a'] > 0){
                sb.append(currentChar);
                chars[currentChar - 'a']--;
            }
        }
        for (int i = 0; i < chars.length; i++){
            while (chars[i] > 0){
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}