public class MinDistance_72 {
    public int minDistance(String word1, String word2){
        int  len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int j = 1; j <= len2; ++j) dp[0][j] = dp[0][j-1] + 1;
        for(int i = 1; i <= len1; ++i) dp[i][0] = dp[i-1][0] + 1;
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i-1][j-1];
                else {
                    int tmp_min = Math.min(dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j] = Math.min(tmp_min, dp[i-1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
