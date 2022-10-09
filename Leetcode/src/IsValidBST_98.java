import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST_98 {
    List<Integer> vals;
    public boolean isValidBST(TreeNode root){
        if(root == null) return false;
        if(root.right == null && root.left == null) return true;
        vals = new ArrayList<>();
        inorder(root);
        for(int i=1; i < vals.size(); ++i){
            if(vals.get(i) < vals.get(i-1)) return false;
        }
        return true;
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        vals.add(node.val);
        inorder(node.right);
    }


    private boolean recur(TreeNode node, long lower, long upper){
        if(node == null) return true;
        if(node.val <= lower || node.val >= upper) return false;
        return recur(node.left, lower, node.val) && recur(node.right, node.val, upper);
    }
}
