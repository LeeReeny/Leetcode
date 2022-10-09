import java.util.PriorityQueue;

public class NthUglyNumber {
    public int nthUglyNumber(int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 1;
        for(int i=1; i<n; i++){
            pq.add(ans * 2);
            pq.add(ans * 3);
            pq.add(ans * 5);
            ans = pq.peek();
            pq.poll();
            while(!pq.isEmpty() && ans==pq.peek()){
                pq.poll();
            }
        }
        return (int)ans;
    }

    public int nthUglyNumber_1(int n){
        //Three pointers
        if(n == 0) return 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 0, j = 0, k = 0;
        for(int p = 1; p < n; ++p){
            int tmp = Math.min(2 * ugly[i], 3 * ugly[j]);
            tmp = Math.min(tmp, 5 * ugly[k]);
            if(tmp == 2 * ugly[i]) ++i;
            if(tmp == 3 * ugly[j]) ++j;
            if(tmp == 5 * ugly[k]) ++k;
            ugly[p] = tmp;
        }
        return ugly[n-1];
    }
}
