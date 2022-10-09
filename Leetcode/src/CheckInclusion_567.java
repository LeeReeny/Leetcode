import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckInclusion_567 {
    public boolean checkInclusion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        char[] ary1 = s1.toCharArray();
        char[] ary2 = s2.toCharArray();

        int[] record1 = new int[26];
        for(char c : ary1){
            ++record1[c-'a'];
        }

        int l=0, r=0;
        while(l <= m-n){
            while(r<l+n && record1[ary2[r]-'a'] >= 1){
                --record1[ary2[r]-'a'];
                ++r;
            }
            if(r == l+n) return true;
            ++record1[ary2[l]-'a'];
            l++;
        }
        return false;
    }
}
