import java.util.Arrays;
import java.util.HashSet;

class mincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] minCost = new int[days[days.length - 1]];
        HashSet<Integer> set = new HashSet<>();
        for (int day : days){
            set.add(day);
        }
        for(int i = 1; i < minCost.length; i++){
            if(!set.contains(i)){
                minCost[i] = minCost[i-1];
                continue;
            }
            int min = costs[0] + minCost[i - 1];
            min = Math.min(min, minCost[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, i - 30)] + costs[2]);

            minCost[i] = min;
        }

        return minCost[minCost.length - 1];
    }
}