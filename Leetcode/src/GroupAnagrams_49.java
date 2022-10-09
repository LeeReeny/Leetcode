import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> hash = new HashMap<>();
        for(String str : strs){
            int[] cnts = new int[26];
            for(char c : str.toCharArray()) cnts[c-'a']++;
             StringBuilder sb = new StringBuilder();
             for(int i=0; i < 26; ++i){
                 if(cnts[i] > 0){
                     sb.append((char)'a'+i);
                     sb.append(cnts[i]);
                 }
             }
             String key = sb.toString();
             List<String> list = hash.getOrDefault(key, new ArrayList<>());
             list.add(str);
             hash.put(key, list);
        }
        return new ArrayList<>(hash.values());
    }
}
