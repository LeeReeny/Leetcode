public class HamingDisatance_461 {
    public int hammingDistance(int x, int y){
        int res = x ^ y;
        int ans = 0;
        while(res > 0){
            ans += res%2 == 1 ? 1 : 0;
            res /= 2;
        }
        return ans;
    }

    public int hammingDistance_system(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}
