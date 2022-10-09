import java.util.HashMap;

public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> hash = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!hash.containsKey(s.charAt(i))){
                if(hash.containsValue(t.charAt(i))) return false;
                hash.put(s.charAt(i), t.charAt(i));
            }else{
                if(hash.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
