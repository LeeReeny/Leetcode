import java.util.Stack;

public class RemoveKDigits_402 {
    public String removeKDigits(String num, int k){
        if (num.length() == k) return "0";

        StringBuilder stack = new StringBuilder();
        int remain = num.length() - k;
        for (int i=0;i<num.length();i++) {
            char c = num.charAt(i);
            while(k>0&&stack.length()!=0 && stack.charAt(stack.length()-1) > c) {
                stack.setLength(stack.length() -1);
                k--;
            }

            if (c == '0' && stack.length()==0 ){continue;}
            stack.append(c);
        }
        String result = stack.substring(0,stack.length()-k <1 ?0:stack.length()-k).toString();
        return result.length() ==0 ? "0":result ;
    }
}
