import java.util.HashMap;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0) return 0;
        char[] ary = s.toCharArray();
        int left = 0, max = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < ary.length; i++){
            if(hash.containsKey(ary[i])){
                left = Math.max(left, hash.get(ary[i])+1);
            }
            hash.put(ary[i], i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
