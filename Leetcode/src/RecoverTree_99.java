import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class RecoverTree_99 {
    // 迭代
    public void recoverTree(TreeNode root) {
        TreeNode mistake1 = null, mistake2 = null, prev = prev = new TreeNode(Integer.MIN_VALUE);
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode p = root;
        while(p != null || !s.isEmpty()){
            while(p != null){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            if(mistake1 == null && prev.val > p.val) mistake1 = prev;
            if(mistake1 != null && prev.val > p.val) mistake2 = p;
            prev = p;
            p = p.right;
        }
        int tmp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = tmp;
    }

     // 递归
    TreeNode mistake1, mistake2, prev;
    public void recoverTree_1(TreeNode root){
        mistake1 = null;
        mistake2 = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int tmp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = tmp;
    }

    public void inorder(TreeNode node){
        if(node == null) return;
        if(node.left != null) inorder(node.left);
        if(mistake1 == null && prev.val > node.val) mistake1 = prev;
        if(mistake1 != null && prev.val > node.val) mistake2 = node;
        prev = node;
        inorder(node.right);
    }
}
