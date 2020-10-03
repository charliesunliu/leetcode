import java.util.*;

class MultiChar {
    int count;
    char letter;
    MultiChar(int ct, char ch) {
        count = ct;
        letter = ch;
    }
}

class reorganizeString {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i)
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) return "";
                pq.add(new MultiChar(count[i], (char) ('a' + i)));
            }

        StringBuilder ans = new StringBuilder();

        while (pq.size() >= 2) {
            MultiChar mulc1 = pq.poll();
            MultiChar mulc2 = pq.poll();
            ans.append(mulc1.letter);
            ans.append(mulc2.letter);
            if (mulc1.count > 1) {
                mulc1.count--;
                pq.add(mulc1);
            }
            if (mulc2.count > 1) {
                mulc2.count--;
                pq.add(mulc2);
            }
        }
        if (pq.size() != 0){
            ans.append(pq.poll().letter);
        }
        return ans.toString();
    }
}