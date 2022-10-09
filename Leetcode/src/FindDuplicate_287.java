public class FindDuplicate_287 {
    public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = nums[slow];
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
