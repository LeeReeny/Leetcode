public class LengthOfLsatWord_58 {
    public int lengthOfLastWord(String s){
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) == ' ') --i;
        int cnt = 0;
        while(i>=0 && s.charAt(i) != ' '){
            --i;
            ++cnt;
        }
        return cnt;
    }
}
