import DataStructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Rob_337 {
    /*哈哈哈哈层序遍历是做不出来的，
    *因为只是不能与父房子同时抢，
    * 不代表不能和父节点的兄弟节点同时抢，
    * 也就是说并不是相邻层的都不能同时抢
    * 写了个寂寞哈哈哈哈哈哈
     */
    public int rob_error(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(root.val);
        int i = 2, res = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            while(size-- > 0){
                TreeNode node = queue.pollFirst();
                if(node.left != null){
                    sum += node.left.val;
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    sum += node.right.val;
                    queue.addLast(node.right);
                }
            }
            dp.add(Math.max(sum+dp.get(i-2), dp.get(i-1)));
            res = Math.max(res, dp.get(i));
            ++i;
        }
        return res;
    }

    public int rob(TreeNode root){
        int[] result = recurRob(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recurRob(TreeNode node){
        if(node == null) return new int[2];
        int[] result = new int[2];
        int[] left = recurRob(node.left);
        int[] right = recurRob(node.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;

        return result;
    }
}
