import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindItinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets){
        List<String> ans = new ArrayList<>();
        HashMap<String, List<String>> hash = new HashMap<>();
        for(List<String> list : tickets){
            if(hash.containsKey(list.get(0))) {
                List<String> tmp = hash.get(list.get(0));
                tmp.add(list.get(1));
                hash.put(list.get(0), tmp);
            }
            else{
                List<String> newList = new ArrayList<>();
                newList.add(list.get(1));
                hash.put(list.get(0), newList);
            }
        }
        String from = "JFK";
        for(int i=0; i<tickets.size(); i++){
            List<String> dests = hash.getOrDefault(from, null);
            String tmp = from;
            /*
            if(dests.isEmpty()) hash.remove(from);
            else{
                List<String> valid_st = new ArrayList<>();
                for(String st : dests){
                    if(hash.containsKey(st)){
                        valid_st.add(st);
                    }
                }
                from = getLeast(valid_st);
                dests.remove(from);
                hash.put(tmp, dests);
            }
            */
            List<String> valid_st = new ArrayList<>();
            for(String st : dests){
                if(hash.containsKey(st)){
                    valid_st.add(st);
                }
            }
            from = getLeast(valid_st);
            dests.remove(from);
            if(!dests.isEmpty()) hash.put(tmp, dests);
        }
        return ans;
    }

    public String getLeast(List<String> dest){
        String camp = "ZZZ";
        for(String s : dest){
            if(s.compareTo(camp) <= 0){
                camp = s;
            }
        }
        return camp;
    }


}
