import java.util.HashMap;
import java.util.Map;

public class ConvertToTitle_168 {
    public String convertToTitle(int columnNumber){
        String ans = "";
        while(columnNumber > 0){
            int num = (columnNumber - 1) % 26 + 1;
            ans = (char)(num - 1 + 'A') + ans;
            columnNumber = (columnNumber - num) / 26 ;
        }
        return ans;
    }

}
