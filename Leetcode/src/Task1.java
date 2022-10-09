public class Task1 {
    public int[] solution(String R, int[] V){
        int[] ans = new int[2];
        if(V.length < 2) return ans;
        ans[0] = V[0];
        ans[1] = V[1];
        for(int i = 0; i < R.length(); ++i){
            if(R.charAt(i) == 'A'){
                ans[0] += V[i];
                ans[1] -= V[i];
            }
            if(R.charAt(i) == 'B'){
                ans[0] -= V[i];
                ans[1] += V[i];
            }
        }
        return ans;
    }
}
