import java.util.*;

class topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words){
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1, w2) -> frequency.get(w1).equals(frequency.get(w2)) ?
                w2.compareTo(w1) : frequency.get(w1) - frequency.get(w2));

        for (String word : frequency.keySet()){
            pq.offer(word);
            if (pq.size() > k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()) result.add(pq.poll());
        Collections.reverse(result);
        return result;
    }
}