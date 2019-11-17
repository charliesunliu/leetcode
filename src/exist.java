import java.util.HashSet;

class exist {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                HashSet<String> set = new HashSet<>();
                if (existHelper(board, word, i, j, set)){
                    return true;
                }
            }
        }

        return false;
    }
    private boolean existHelper(char[][] board, String word, int i, int j, HashSet<String> set){
        if (word.length() == 0){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || set.contains(i+"-"+j)){
            return false;
        }
        if (board[i][j] == word.charAt(0)){
            set.add(i+"-"+j);
            if (existHelper(board, word.substring(1),i -1 ,j,set) || existHelper(board, word.substring(1),i +1 ,j,set) || existHelper(board, word.substring(1),i ,j-1,set) || existHelper(board, word.substring(1),i ,j+1,set)){
                return true;
            }
            set.remove(i+"-"+j);
        }
        return false;
    }
}