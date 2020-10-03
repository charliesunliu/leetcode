import java.util.*;

class Leaderboard {
    TreeMap<Integer, Integer> scores;
    HashMap<Integer, Integer> board;
    public Leaderboard() {
        scores = new TreeMap<>(Collections.reverseOrder());
        board = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (board.containsKey(playerId)){
            int preScore = board.get(playerId);
            board.put(playerId, board.get(playerId) + score);
            scores.put(preScore, scores.get(preScore) - 1);
            if (scores.get(preScore) == 0){
                scores.remove(preScore);
            }
            scores.put(board.get(playerId), scores.getOrDefault(board.get(playerId), 0)+1);
        }else {
            board.put(playerId, score);
            scores.put(score, scores.getOrDefault(board.get(playerId), 0)+1);
        }
//        System.out.println("start");
//        for (int key : scores.keySet()){
//            System.out.println(  key+ "-----" + scores.get(key));
//        }
//        System.out.println("end");
    }

    public int top(int K) {
        int count = 0;
        int sum = 0;
        for (int key : scores.keySet()){
            int times = scores.get(key);
            for (int i = 0; i < times; i++) {
                if (count == K){
                    return sum;
                }
                sum += key;
                count ++;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int score = board.get(playerId);
        scores.put(score, scores.get(score) - 1);
        if(scores.get(score) == 0){
            scores.remove(score);
        }
        board.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */