public class shortestWordDistanceIII {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;

        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1) && !word1.equals(word2)){
                pos1 = i;
            }
            if (words[i].equals(word2) && !word1.equals(word2)){
                pos2 = i;
            }
            if (words[i].equals(word2) && word1.equals(word2)){
                if (pos1 <= pos2){
                    pos1 = i;
                }else {
                    pos2 = i;
                }
            }
            if (pos1 >= 0 && pos2 >= 0){
                distance = Math.min(distance, Math.abs(pos1 - pos2));
            }
        }


        return distance;
    }
}
