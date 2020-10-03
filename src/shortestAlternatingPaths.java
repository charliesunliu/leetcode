import java.util.*;

class shortestAlternatingPaths {
//    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
//        Set<Integer>[][] graph = new HashSet[2][n];
//        for (int i = 0; i < n; i++){
//            graph[0][i] = new HashSet<>();
//            graph[1][i] = new HashSet<>();
//        }
//        for (int[] re : red_edges){
//            graph[0][re[0]].add(re[1]);
//        }
//        for(int[] bl : blue_edges){
//            graph[1][bl[0]].add(bl[1]);
//        }
//
//        int[][] res = new int[2][n];
//
//        for (int i = 1; i < n; i++){
//            res[0][i] = 2 * n;
//            res[1][i] = 2 * n;
//        }
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{0,0});
//        q.offer(new int[]{1,0});
//
//        while (!q.isEmpty()){
//            int[]cur = q.poll();
//            int vert = cur[1];
//            int color = cur[0];
//            for (int next  :  graph[1 - color][vert]){
//                if (res[1 - color][next] == 2*n){
//                    res[1-color][next] = 1 + res[color][vert];
//                    q.offer(new int[]{1 - color, next});
//                }
//            }
//        }
//
//
//
//    }
}