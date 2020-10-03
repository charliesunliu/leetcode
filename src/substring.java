import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


class substring {
    public long[] substring(long[] numbers) {
        // Type your solution here
        HashMap<Long, Integer> freq = new HashMap();

        for (long l : numbers){
            freq.put(l, freq.getOrDefault(l, 0) + 1);
        }
        int maxCount = Integer.MAX_VALUE;
        ArrayList<Long> result = new ArrayList<>();
        for (long l : freq.keySet()){
            if (freq.get(l) < maxCount){
                maxCount = freq.get(l);
                result = new ArrayList<>();
                result.add(l);
            } else if(maxCount == freq.get(l)){
                result.add(l);
            }
        }
        final long[] values = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            values[i] = result.get(i);
        }
        return values;
    }
}


