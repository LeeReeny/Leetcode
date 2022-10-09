import java.util.HashSet;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> hash = new HashSet<>();
        for(int num : nums){
            if(hash.contains(num)) return true;
            hash.add(num);
        }
        return false;
    }


}
