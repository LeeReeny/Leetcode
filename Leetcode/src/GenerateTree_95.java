import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTree_95 {
    List<TreeNode> ans;
    public List<TreeNode> generateTrees(int n){
        ans = new ArrayList<>();
        if(n == 0) return ans;
        return recur(1, n);
    }

    public List<TreeNode> recur(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){  // 没有数字
            ans.add(null);
            return ans;
        }
        if(start == end){  // 只有一个数字，加入结果
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        for(int i = start; i <= end; ++i){  // 尝试将每个数字作为根节点
            List<TreeNode> leftTrees = recur(start, i-1);
            List<TreeNode> rightTrees = recur(i+1, end);
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
