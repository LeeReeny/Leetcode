public class LongestPalindrome_5 {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2) return s;
        char[] ary = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(ary[i] != ary[j]) dp[i][j] = false;
                else{
                    if(j-i < 3) dp[i][j] = true;
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String Manacher_longestPalindrome(String s){
        int len = s.length();
        if(len < 2) return s;
        int begin = 0;
        int maxLen = 0;

        char[] ary = s.toCharArray();
        for(int i=0; i<ary.length-1; i++){
            int[] odd = centerSpread(ary, i, i);
            int[] even = centerSpread(ary, i, i+1);
            int[] max = odd[1] > even[1] ? odd : even;
            if(max[1] > maxLen){
                maxLen = max[1];
                begin = max[0];
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public int[] centerSpread(char[] ary, int left, int right){
        while(left >= 0 && right < ary.length){
            if(ary[left] == ary[right]){
                left--;
                right++;
            }
            else break;
        }
        return new int[]{left+1, right-left-1};
    }
}
