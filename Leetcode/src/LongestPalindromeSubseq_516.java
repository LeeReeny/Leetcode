public class LongestPalindromeSubseq_516 {
    public static int longestPalindromeSubseq(String s) {
        if(s == null) return 0;
        StringBuffer tmp = new StringBuffer(s).reverse();
        String reverse_s = tmp.toString();
        return longestCommonSubseq(s, reverse_s);
    }

    public static int longestCommonSubseq(String s1, String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int L[][] = new int[length1+1][length2+1];
        //L[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for(int i = 1; i < length1 + 1; i++){
            for(int j = 1; j < length2 + 1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[length1][length2];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
