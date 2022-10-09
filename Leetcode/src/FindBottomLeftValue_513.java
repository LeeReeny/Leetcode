import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class FindBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;

        while(!q.isEmpty()){
            ans = q.peek().val;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return ans;
    }

}
