import DataStructure.TreeNode;


public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return subTree(root.left, root.right);
    }

    public boolean subTree(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return subTree(left.left, right.right) && subTree(left.right, right.left);
    }
}
