import javafx.util.Pair;
import java.util.*;

public class GetSkyline_218 {
    public List<List<Integer>> getSkyline(int[][] buildings){
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> ps = new ArrayList<>();
        for(int[] b : buildings){
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, h, -1});
            ps.add(new int[]{r, h, 1});
        }
        Collections.sort(ps, (a, b) ->{
            if(a[0] != b[0]) return a[0]-b[0];
            if(a[2] != b[2]) return a[2]-b[2];
            if(a[2] == -1){
                return b[1]-a[1];
            }
            else{
                return a[1]-b[1];
            }
        });
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b-a);
        int prev = 0;
        max_heap.add(prev);
        for(int[] p : ps){
            int point = p[0], height = p[1], flag=p[2];
            if(flag == -1){
                max_heap.add(height);
            }
            else{
                max_heap.remove(height);
            }
            int cur_h = max_heap.peek();
            if(cur_h != prev){
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(cur_h);
                ans.add(list);
                prev = cur_h;
            }
        }
        return ans;
    }
}
