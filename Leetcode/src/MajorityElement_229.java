import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement_229 {
    public List<Integer> majorityElement(int[] nums){
        int n = nums.length;
        if(n == 1) return Arrays.asList(nums[0]);
        int num1 = nums[0], cnt1 = 0;
        int num2 = nums[1], cnt2 = 0;

        for(int num : nums){
            if(num == num1){
                ++cnt1;
                continue;
            }

            if(num == num2){
                ++cnt2;
                continue;
            }

            if(cnt1 == 0){
                num1 = num;
                ++cnt1;
                continue;
            }
            else if(cnt2 == 0){
                num2 = num;
                ++cnt2;
                continue;
            }

            --cnt1;
            --cnt2;
        }

        cnt1 = 0;
        cnt2 = 0;
        // 找到两个候选人之后要确定票数是否大于n/3
        for(int num : nums){
            if(num == num1) ++cnt1;
            else if(num == num2) ++ cnt2;
        }

        List<Integer> res = new ArrayList<>();
        if(cnt1 > n / 3) res.add(num1);
        if(cnt2 > n / 3) res.add(num2);
        return res;
    }
}
