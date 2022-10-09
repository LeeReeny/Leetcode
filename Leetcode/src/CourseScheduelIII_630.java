import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduelIII_630 {
    public int scheduelCourse(int[][] courses){
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);  // 按照第二位元素进行排序
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        int time = 0;
        for(int[] c:courses){
            if(time + c[0] <= c[1]){
                queue.offer(c[0]);
                time += c[0];
            }else if(!queue.isEmpty() && queue.peek() > c[0]){
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
