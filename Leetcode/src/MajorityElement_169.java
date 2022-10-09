public class MajorityElement_169 {
    public int majorityElement(int[] nums){
        // Boyer-Moore Majority Vote Algorithm
        int cur = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                cur = nums[i];
                cnt++;
            }
            else{
                if(cur == nums[i]) cnt++;
                else cnt--;
            }
        }
        return cur;
    }
}
