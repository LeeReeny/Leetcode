import DataStructure.TreeNode;

import java.util.*;

public class LevelOrder_offer32 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        boolean isEven = false;
        while(true){
            int size = dq.size();
            LinkedList<Integer> item = new LinkedList<>();
            for(int i=0;i<size;i++){
                root = dq.poll();
                if(!isEven) item.addLast(root.val);
                else item.addFirst(root.val);

                if(root.left!=null) dq.offer(root.left);
                if(root.right!=null) dq.offer(root.right);
            }
            isEven = !isEven;
            res.add(item);
            if(dq.isEmpty()) break;
        }
        return res;
    }
}
