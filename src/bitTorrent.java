import java.util.*;

class insert{
    public int[][] insert(int[][] intervals, int[] newInterval) {

        TreeMap<Integer, int[]> treeMap = new TreeMap<>();
        //int size = 0;
        for(int[] interval : intervals) {
            treeMap.put(interval[0], interval);
            //size += interval[1] - interval[0];
        }
        int[] cur = newInterval;

        //int newAdding = newInterval[1] - newInterval[0];


        while(treeMap.floorEntry(cur[1]) != null && treeMap.floorEntry(cur[1]).getValue()[1] >= cur[0]) {
            int[] out;
            int[] curCopy = new int[]{cur[0], cur[1]};

            if(treeMap.floorEntry(cur[0]) != null && treeMap.floorEntry(cur[0]).getValue()[1] >= cur[0]) {
                out = treeMap.floorEntry(cur[0]).getValue();
                treeMap.remove(treeMap.floorKey(cur[0]));
                cur[0] = out[0];
                cur[1] = Math.max(cur[1], out[1]);
            }else{
                out = treeMap.floorEntry(cur[1]).getValue();
                treeMap.remove(treeMap.floorKey(cur[1]));
                cur[1] = Math.max(cur[1], out[1]);
                cur[0] = Math.min(cur[0], out[0]);
            }

            //int[] overLapping = new int[]{ Math.max(out[0], curCopy[0]), Math.min(out[1], curCopy[1])};
            //newAdding -= overLapping[1] - overLapping[0];


        }
        //System.out.println(size + newAdding);
        treeMap.put(cur[0], cur);
        int[][] result = new int[treeMap.size()][2];
        int i = 0;
        for (int[] value : treeMap.values()){
            result[i][0] = value[0];
            result[i][1] = value[1];
            i++;
        }

        return result;
    }
}
