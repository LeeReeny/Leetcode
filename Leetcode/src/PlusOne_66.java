public class PlusOne_66 {
    public int[] plusOne(int[] digits){
        int n = digits.length;
        int carry = 0;
        for(int i=n-1; i>=0; --i){
            if(i == n-1){
                carry = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            }
            else {
                int cur = digits[i] + carry;
                digits[i] = cur % 10;
                carry = cur / 10;
            }
        }
        if(carry != 0){
            int[] ans = new int[n+1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, n);
            return ans;
        }
        else return digits;
    }
}
