import java.util.*;

public class ValidateStackSequence_946 {
    public boolean validateStackSequence(int[] pushed, int[] popped){
      
        int n = popped.length;
        if(n == 0) return true;
        Deque<Integer> s = new ArrayDeque<>();
        int po = 0;
        for(int i = 0; i < n; ++i){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[po]){
                s.pop();
                ++po;
            }
        }
        return s.isEmpty();
    }
}
