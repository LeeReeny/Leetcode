public class CountSubstrings_647 {
    public int countSubStrings(String s){
        char[] ary = s.toCharArray();
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            ans += subStrings(ary, i, i);
            ans += subStrings(ary, i, i+1);
        }
        return ans;
    }

    public int subStrings(char[] ary, int l, int r){
        int cnt = 0;
        while(l >= 0 && r<ary.length && ary[l]==ary[r]){
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}
