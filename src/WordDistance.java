import java.util.ArrayList;
import java.util.HashMap;

class WordDistance {
    private HashMap<String, ArrayList<Integer>> wordMap;
    public WordDistance(String[] words) {
        wordMap = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++){
            if (wordMap.containsKey(words[i])){
                wordMap.get(words[i]).add(i);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                wordMap.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList list1 = wordMap.get(word1);
        ArrayList list2 = wordMap.get(word2);

        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (diff != 0 || (i < list1.size() && j < list2.size())){
            int a = (int)list1.get(i);
            int b = (int)list2.get(j);
            diff =  Math.min(diff,Math.abs(a-b));

            if (a <= b){
                i++;
            }else {
                j++;
            }



        }
        return diff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */