import DataStructure.TreeNode;

public class Flatten_114 {
    public void flatten(TreeNode root){
        while(root != null){
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) { //找到左子树的最右节点
                    pre = pre.right;
                }
                pre.right = root.right; // 原来的右子树接到左子树的最右节点下
                root.right = root.left;  // 原来的左子树作为root的右子树
                root.left = null;
            }
            root = root.right; // 考虑下一个节点
        }
    }
}
