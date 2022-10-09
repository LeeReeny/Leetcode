import DataStructure.TreeNode;

public class DiameterOfBinaryTree_543 {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root){
        diameter = 1;
        findDiameter(root);
        return diameter-1;
    }

    public int findDiameter(TreeNode node){
        if(node == null) return 0;
        int left = findDiameter(node.left);
        int right = findDiameter(node.right);
        diameter = Math.max(left + right + 1, diameter);
        return Math.max(left, right) + 1;
    }
}
