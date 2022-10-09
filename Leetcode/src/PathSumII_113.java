import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(targetSum, root);
        return res;
    }

    public void dfs(int sum, TreeNode node){
        if(node == null) return;

        path.add(node.val);
        sum -= node.val;
        if(sum == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs(sum, node.left);
        dfs(sum, node.right);
        path.remove(path.size()-1);

    }
}
