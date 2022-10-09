import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            double sum = 0.0;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                TreeNode node = q.poll();
                q.remove();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
