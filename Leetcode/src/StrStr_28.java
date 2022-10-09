import java.util.ArrayList;
import java.util.List;

// KMP算法
public class StrStr_28 {
    public int strStr(String haystack, String needle){
        int h = haystack.length(), n = needle.length();
        if(n == 0) return 0;
        if(h == 0) return -1;

        char[] hAry = haystack.toCharArray();
        char[] nAry = needle.toCharArray();
        int[] next = getNext(nAry, h);

        int i = 0, j = 0;
        while(i < h && j < n){
            if(j < 0 || hAry[i] == nAry[j]){
                i++;
                j++;
            }
            else j = next[j];
        }
        return j >= n ? i - n : -1;
    }

    public int[] getNext(char[] nAry, int l){
        int[] next = new int[nAry.length];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < l-1){
            if(j < 0 || nAry[i] == nAry[j]){
                i++;
                j++;
                next[i] = nAry[i] != nAry[j] ? j : next[j];
            }
            else j = next[j];
        }
        return next;
    }

}
