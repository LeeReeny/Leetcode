import java.util.HashMap;
import java.util.Map;

public class MaxProduct_318 {
    public int maxProduct(String[] words){
        Map<Integer, Integer> len2Bits = new HashMap<>();
        int ans = 0;
        for(String word : words){
            int mask = 0;
            int size = word.length();
            for(char ch : word.toCharArray()){
                mask |= 1 << (ch - 'a');
            }
            len2Bits.put(mask, Math.max(len2Bits.getOrDefault(mask,0), size));
            for(Map.Entry<Integer, Integer> entry : len2Bits.entrySet()){
                if((entry.getKey() & mask) == 0){
                    ans = Math.max(ans, size * entry.getValue());
                }
            }
        }
        return ans;
    }
}
