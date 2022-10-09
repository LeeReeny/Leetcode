import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        PriorityQueue<int[]> sort_n2 = new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for(int i=0; i<nums2.length; i++){
            sort_n2.offer(new int[]{i, nums2[i]});
        }
        int[] res = new int[n];
        int l = 0, r = n-1;
        while(!sort_n2.isEmpty()){
            int[] n2 = sort_n2.poll();
            if(nums1[r] > n2[1]) res[n2[0]] = nums1[r--];
            else res[n2[0]] = nums1[l++];
        }
        return res;
    }
}
