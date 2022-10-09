import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findObject(int numCourses, int[][] prerequisites){
        int[] indegrees = new int[numCourses];
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0) queue.add(i);
        }
        int[] course = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int c = queue.poll();
            course[idx++] = c;
            for(int[] c_neigh : prerequisites){
                if(c_neigh[1] == c){
                    indegrees[c_neigh[0]]--;
                    if(indegrees[c_neigh[0]] == 0) queue.offer(c_neigh[0]);
                }
            }
        }
        return numCourses == idx ? course : (new int[0]);
    }
}
