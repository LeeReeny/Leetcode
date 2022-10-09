import DataStructure.TreeNode;

import java.util.HashMap;

public class PathSum_437 {
    public int pathSum(TreeNode root, int targetSum){
        return root == null ? 0 : sumFromNode(root, targetSum) +
                pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int sumFromNode(TreeNode node, int sum){
        if(node == null) return 0;
        int cnt = node.val == sum? 1 : 0;
        cnt += sumFromNode(node.left, sum-node.val);
        cnt += sumFromNode(node.right, sum-node.val);
        return cnt;
    }

    public int pathSum_1(TreeNode root, int targetSum){
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return recurPathSum(root, prefixSum, targetSum, 0);
    }

    public int recurPathSum(TreeNode node, HashMap<Integer, Integer> prefixSum, int target, int curSum){
        if(node == null) return 0;

        int res = 0;
        curSum += node.val;

        res += prefixSum.getOrDefault(curSum-target, 0);
        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0)+1);

        res += recurPathSum(node.left, prefixSum, target, curSum);
        res += recurPathSum(node.right, prefixSum, target, curSum);

        prefixSum.put(curSum, prefixSum.get(curSum)-1);
        return res;
    }
}
