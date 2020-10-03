import java.util.List;

class maxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int distance = 0;
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> l = arrays.get(i);
            distance = Math.max(distance, max - l.get(0));
            distance = Math.max(distance, l.get(l.size() - 1) - min);
            min = Math.min(min, l.get(0));
            max = Math.max(max, l.get(l.size() - 1));
        }

        return distance;
    }
}