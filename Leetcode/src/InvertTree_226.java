import DataStructure.TreeNode;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root){
        if(root == null) return root;
        TreeNode leftchild = root.left;
        root.left = root.right;
        root.right = leftchild;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
