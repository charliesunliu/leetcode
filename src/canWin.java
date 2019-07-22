import java.util.ArrayList;
import java.util.List;

class canWin {
    public boolean canWin(String s) {
        return canWinMinusHelper(s);
    }
    private boolean canWinMinusHelper(String s){

        List<String> moves = new ArrayList<String>();
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                if (s.charAt(i) == '+'){
                    moves.add(s.substring(0, i) + "--" + s.substring(i+2, s.length()));
                }
            }
        }
        if (moves.size() == 0){
            return false;
        } else {
            for (String next : moves){
                if(canWinPlusHelper(next)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean canWinPlusHelper(String s){

        List<String> moves = new ArrayList<String>();
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                if (s.charAt(i) == '+'){
                    moves.add(s.substring(0, i) + "--" + s.substring(i+2, s.length()));
                }
            }
        }
        if (moves.size() == 0){
            return true;
        } else {
            for (String next : moves){
                if(!canWinMinusHelper(next)){
                    return false;
                }
            }
        }
        return true;
    }
}