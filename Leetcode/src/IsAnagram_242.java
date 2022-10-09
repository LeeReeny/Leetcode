public class IsAnagram_242 {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] ary_s = new int[26];
        int[] ary_t = new int[26];
        for(int i=0; i<s.length(); i++){
            ary_s[s.charAt(i)-'a'] += 1;
            ary_t[t.charAt(i)-'a'] += 1;
        }

        for(int j=0; j<s.length(); j++){
            if(ary_s[j] != ary_t[j]) return false;
        }

        return true;
    }
}
