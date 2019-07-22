import java.util.ArrayList;
import java.util.List;

class generatePossibleNextMoves {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                if (s.charAt(i) == '+'){
                    result.add(s.substring(0, i) + "--" + s.substring(i+2, s.length()));
                } else {
                    result.add(s.substring(0, i) + "++" + s.substring(i+2, s.length()));
                }
            }
        }

        return result;
    }
}