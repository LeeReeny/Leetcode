import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class CalculateEquations_399 {
    private class UnionFind{
        private int[] parent;
        private double[] weights;  // 指向父节点的权值

        public UnionFind(int n){
            this.parent = new int[n];
            this.weights = new double[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                weights[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){
            int root_x = find(x);
            int root_y = find(y);
            if(root_x == root_y) return;
            parent[root_x] = root_y;
            weights[root_x] = weights[y] * value / weights[x];
        }

        public int find(int x){  //路径压缩，找到根节点的id
            if(x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weights[x] *= weights[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int root_x = find(x);
            int root_y = find(y);
            if(root_x == root_y){
                return weights[x]/weights[y];
            }
            else return -1.0d;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        int equ_size = equations.size();
        UnionFind unionFind = new UnionFind(2*equ_size);

        //1. 预处理，在变量的值和id之间建立起映射
        Map<String, Integer> hashMap = new HashMap<>(2*equ_size);
        int id = 0;
        for(int i=0; i<equ_size;  i++){
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if(!hashMap.containsKey(var1)){
                hashMap.put(var1,  id);
                id++;
            }

            if(!hashMap.containsKey(var2)){
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        //2. 查询
        int qry_size = queries.size();
        double[] res = new double[qry_size];
        for (int i=0; i<qry_size; i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if(id1 == null || id2 == null){
                res[i] = -1.0d;
            } else{
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }
}
