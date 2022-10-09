import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxPathSum_124 {
    int Max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if(root == null) return 0;
        recur(root);
        return Max;
    }

    private int recur(TreeNode node){
        if(node == null) return 0;
        // 左分支最大值，若为负则不选择
        int leftMax = Math.max(0, recur(node.left));
        // 右分支最大值，若为负则不选择
        int rightMax = Math.max(0, recur(node.right));
        // 将left->root->right路径于已记录的路径最大值进行比较
        Max = Math.max(Max, node.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return node.val + Math.max(leftMax, rightMax);
    }
}
