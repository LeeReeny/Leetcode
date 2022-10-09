import DataStructure.TreeNode;

public class MergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        TreeNode union = new TreeNode((root1==null ? 0:root1.val) + (root2 == null ? 0 : root2.val));
        union.left = mergeTrees(root1==null ? null:root1.left, root2==null ? null:root2.left);
        union.right = mergeTrees(root1==null ? null:root1.right, root2==null ? null:root2.right);
        return union;
    }

    public TreeNode mergeTrees_1(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode union = new TreeNode(root1.val + root2.val);
        union.left = mergeTrees_1(root1.left, root2.left);
        union.right = mergeTrees_1(root1.right, root2.right);
        return union;
    }
}
