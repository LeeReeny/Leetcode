import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        recur(root, ans);
        return ans;
    }

    public void recur(TreeNode node, List<Integer> ans){
        if(node == null) return;
        ans.add(node.val);
        recur(node.left, ans);
        recur(node.right, ans);
    }

    public List<Integer> preorderTraversal_1(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            ans.add(node.val);
            if(node.left != null) s.push(node.left);
            if(node.right != null) s.push(node.right);
        }
        return ans;
    }
}
