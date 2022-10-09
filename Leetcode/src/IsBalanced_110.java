import DataStructure.TreeNode;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root){
        return judge(root) != -1;
    }

    public int judge(TreeNode root){
        if(root == null) return -1;
        int left = judge(root.left), right = judge(root.right);

        if(left == -1 || right == -1 || Math.abs(right - left) > 1) return -1;
        return 1 + Math.max(judge(root.left), judge(root.right));
    }
}
