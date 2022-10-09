import java.util.ArrayList;
import java.util.List;

public class Insert_57 {
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> mergeList = new ArrayList<>();
        boolean added = false;
        for(int i=0; i<intervals.length; ++i){
            int L = intervals[i][0], R = intervals[i][1];
            if(R < newInterval[0] || L > newInterval[1]) mergeList.add(intervals[i]);
            else{
                int left = Math.min(L, newInterval[0]);  //合并区间的左边界
                int  right = newInterval[1];
                while(intervals[i++][0] < newInterval[1]) right = Math.max(right, intervals[i][1]);  // 这里i跳得有问题导致不通过
                mergeList.add(new int[]{left, right});
                added = true;
            }
            if(!added) mergeList.add(newInterval);
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }

    public int[][] insert_1(int[][] intervals, int[] newInterval){
        List<int[]> mergeList = new ArrayList<>();
        int len = intervals.length, i = 0;
        while(i < len && intervals[i][1] < newInterval[0]){
            mergeList.add(intervals[i]);
            ++i;
        }
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            ++i;
        }
        mergeList.add(newInterval);
        while(i < len && intervals[i][1] > newInterval[1]){
            mergeList.add(intervals[i]);
            ++i;
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
