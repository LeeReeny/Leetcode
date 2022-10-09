import DataStructure.TreeNode;

public class TreeToDoubleList {
    TreeNode pre, head;
    public TreeNode trerToDoublyList(TreeNode root){
        if(root == null) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur){
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;  // 找到最左下节点作为head
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
