import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class findCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> flightMap = new HashMap<>();
        for (int[] flight : flights){
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            if (flightMap.containsKey(start)){
                flightMap.get(start).put(end, price);
            } else {
                flightMap.put(start, new HashMap<>());
                flightMap.get(start).put(end, price);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0, -1});

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int start = top[0];
            int price = top[1];
            int stops = top[2];

            if (stops>= K){
                continue;
            }
            if (start == dst){
                return price;
            }
            HashMap<Integer, Integer> nextStops = flightMap.getOrDefault(start, new HashMap<>());
            for (int key : nextStops.keySet()){
                pq.add(new int[]{key, price + nextStops.get(key), stops+1});
            }
        }

        return -1;

    }
}