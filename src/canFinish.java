import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[course]++;
            graph[pre].add(course);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
                numCourses--;
            }
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i  : graph[current]){
                indegree[i]--;
                if (indegree[i] == 0){
                    queue.add(i);
                    numCourses--;
                }
            }
        }

        return numCourses == 0;
    }
}