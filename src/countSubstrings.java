import java.sql.Array;
import java.util.ArrayList;

class countSubstrings {
    public int countSubstrings(String s) {
        int[][] map = new int[s.length()][s.length()];
        int result = 0;
        for (int offset = 0; offset < s.length(); offset++){
            for (int left = 0; left + offset < s.length(); left++){
                int right = left + offset;
                if (right == left){
                    map[left][right] = 1;
                    result++;

                }
                else if (left + 1 == right && s.charAt(left) == s.charAt(right)){
                    map[left][right] = 1;
                    result++;

                }
//                else if (map[left][right-1] == 1 && s.charAt(left) == s.charAt(right)){
//                    map[left][right] = 1;
//                    result++;
//                    list.add(s.substring(left, right+1));
//                }
                else if (map[left+1][right-1] == 1 && s.charAt(left) == s.charAt(right)){
                    map[left][right] = 1;
                    result++;
                }
            }
        }
        return result;

    }
}