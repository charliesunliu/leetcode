import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class minAreaFreeRect {
    public double minAreaFreeRect(int[][] points) {

        HashMap<String, List<int[]>> distMidpointMap = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++){
            for (int j = i + 1; j < points.length; j++){
                int disSqr = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                String key = disSqr + "," + (double)(points[i][0] + points[j][0])/2 + "," + (double)(points[i][1] + points[j][1])/2;
                if (distMidpointMap.get(key) == null) distMidpointMap.put(key, new ArrayList<int[]>());
                distMidpointMap.get(key).add(new int[]{i,j});
            }
        }
        double res = 0.0;
        for (List<int[]> list : distMidpointMap.values()){
            if (list.size() > 1){
                for (int i = 0; i < list.size(); i++) { // there could be multiple rectangles inside
                    for (int j = i + 1; j < list.size(); j++) {
                        int p1 = list.get(i)[0]; // p1, p2 and p3 are the three vertices of a rectangle
                        int p2 = list.get(j)[0];
                        int p3 = list.get(j)[1];
                        // len1 and len2 are the length of the sides of a rectangle
                        double len1 = Math.sqrt((points[p1][0] - points[p2][0]) * (points[p1][0] - points[p2][0]) +  (points[p1][1] - points[p2][1]) * (points[p1][1] - points[p2][1]));
                        double len2 = Math.sqrt((points[p1][0] - points[p3][0]) * (points[p1][0] - points[p3][0]) +  (points[p1][1] - points[p3][1]) * (points[p1][1] - points[p3][1]));
                        double area = len1 * len2;
                        res = Math.min(res, area);
                    }
                }
            }
        }

        return res;
    }
}
