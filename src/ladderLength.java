import java.util.*;

class ladderLength {
    HashSet<String> set;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int queueLength = 1;
        int result = 1;
        while (!queue.isEmpty()){
            if (queueLength == 0){
                queueLength = queue.size();
                result++;
            }
            String current = queue.poll();
            if (current.equals(endWord)){
                return result;
            }
            for (String word : wordList){
                if (difference(current, word)==1 && !set.contains(word)){
                    set.add(word);
                    queue.add(word);
                }
            }
            queueLength--;
        }
        return 0;
    }

    private int difference(String w1, String w2){
        int count = 0;
        for (int i = 0; i < w1.length(); i++){
            if (w1.charAt(i) != w2.charAt(i)){
                count++;
            }
        }
        return count;
    }
}