public class MaxChunksToSorted_769 {
    public int maxChunksToSorted(int[] arr){
        int num_Chunks = 0;
        int cur_max = 0;
        for(int i=0; i<arr.length; i++){
            cur_max = Math.max(cur_max, arr[i]);
            if(cur_max == i) num_Chunks++;
        }
        return num_Chunks;
    }
}
