import DataStructure.TreeNode;

public class IsSubtree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null) return false;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val != r2.val) return false;
        return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }
}
