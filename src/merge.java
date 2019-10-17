import java.util.Arrays;
import java.util.Comparator;

class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        //index for the copy ending
        int end = 0;
        //left and right
        int left = intervals[0][0]; int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++){
            if (intervals[i][0] > right){
                intervals[end][0] = left; intervals[end][1] = right;
                end++;
                left = intervals[i][0]; right = intervals[i][1];
            }
            else if (intervals[i][1] > right){
                right = intervals[i][1];
            }
        }
        intervals[end][0] = left; intervals[end][1] = right;
        end++;
        return Arrays.copyOfRange(intervals, 0, end+1);
    }
}