public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s){
        char[] ary = s.toCharArray();
        int cnt=0, pre=0, cur=0;
        for(int i=1; i<ary.length; i++){
            if(ary[i] == ary[i-1]){
                cur++;
            }else{
                pre = cur;
                cur = 1;
            }
            if(pre >= cur) cnt++;
        }
        return cnt;
    }
}
