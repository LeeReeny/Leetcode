import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> mergeList = new ArrayList<int[]>();
        for(int i=0; i<intervals.length; ++i){
            int L = intervals[i][0], R = intervals[i][1];
            // 当前合并的list为空或新区间无法合并
            if(mergeList.isEmpty() || mergeList.get(mergeList.size()-1)[1] < L){
                mergeList.add(new int[]{L, R});
            }
            else{
                // 合并两区间
                mergeList.get(mergeList.size()-1)[1] = Math.max(R, mergeList.get(mergeList.size()-1)[1]);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
