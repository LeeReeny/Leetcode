import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s){
        char[] ary = s.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char c : ary){
            int num = hash.getOrDefault(c, 0);
            hash.put(c, num + 1);
        }
        boolean odd = false;
        int ans = 0;
        for(Map.Entry<Character, Integer> entry : hash.entrySet()){
            int val = entry.getValue();
            if(val % 2 != 0){
                ans += odd ? val-1 : val;
                odd = true;
            }
            else ans += val;
        }
        return ans;
    }

    public int longestPalindrome_1(String s){
        int[] ary = new int[128];
        char[] chs = s.toCharArray();
        for(char c : chs){
            ary[c]++;
        }
        int cnt = 0;
        for(int i : ary){
            cnt += i % 2;
        }
        return cnt==0 ? s.length() : s.length()+1-cnt;
    }
}
