import java.util.HashMap;
import java.util.Map;

public class MaxPoints_149 {
    public static int maxPoints(int[][] points){
        int max_num = 0, same_x = 1, same_y = 1;
        HashMap<Double, Integer> hash = new HashMap<>();
        for(int i=0; i<points.length; i++){
            same_x = 1;
            same_y = 1;
            for(int j=i+1; j<points.length; j++){
                if(points[i][1] == points[j][1]){
                    same_y++;
                    if(points[i][0] == points[j][0]) same_x++;
                }
                else{
                    double k = (double)((points[i][0]-points[j][0])/(points[i][1]-points[j][1]));
                    hash.put(k, hash.getOrDefault(k,2)+1);
                }
            }
            max_num = Math.max(max_num, same_y);
            for(Map.Entry<Double, Integer> entry : hash.entrySet()){
                max_num = Math.max(max_num, same_x + entry.getValue());
            }
            hash.clear();
        }
        return max_num;
    }

    public static void main(String[] args) {
        int[][] p = {{2,3}, {3,3}, {-5,3}};
        int[] p1 = {1,1};
        int[] p2 = {2,1};
        System.out.println(maxPoints(p));
        //System.out.println(computeK(p1, p2));
    }
}
