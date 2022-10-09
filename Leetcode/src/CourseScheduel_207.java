import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduel_207 {
    // 拓扑排序算法
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] indgrees = new int[numCourses]; // 入度表
        List<List<Integer>> adjacency = new ArrayList<>(); // 邻接表
        for(int i = 0; i < numCourses; ++i) adjacency.add(new ArrayList<Integer>());
        for(int[] courses : prerequisites) {
            indgrees[courses[0]]++;
            adjacency.get(courses[1]).add(courses[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();  // 入度为0的课程入队
        for(int i = 0; i < numCourses; ++i){
            if(indgrees[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int curCourse = queue.poll();
            numCourses--;
            for(int neigh : adjacency.get(curCourse)){ // 将出队节点的所有邻居节点入度减一
                if(--indgrees[neigh] == 0) queue.add(neigh);  // 如果减一后入度为0则入栈
            }

        }
        return numCourses == 0;
    }
}
