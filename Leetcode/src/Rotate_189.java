public class Rotate_189 {
    public void rotate(int[] nums, int k){
        if(nums.length <= 1 || k == 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int idx1, int idx2){
        while(idx1 < idx2){
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp;
            ++idx1;
            --idx2;
        }
    }

    public void rotate_1(int[] nums, int k){
        int n = nums.length;
        int[] newnums = new int[n];
        for(int i=0; i<n; ++i){
            newnums[(i+k)%n] = nums[i];
        }
        System.arraycopy(newnums, 0, nums, 0, n); //复制数组
    }

    public void rotate_2(int[] nums, int k){
        int n = nums.length;
        k %= n;
        int cnt = gcd(k, n);
        for(int start = 0; start < cnt; ++start){
            int cur = start, pre = nums[start];
            do{
                int next = (cur + k) % n;
                int tmp = nums[next];  // 下一个要交换的元素
                nums[next] = pre;
                pre = tmp;
                cur = next;
            }while(start != cur);
        }
    }

    private int gcd(int x, int y){
        return y > 0 ? gcd(y, x%y) : x;
    }
}
