import DataStructure.TreeNode;

public class IsSubStructure_offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B){
        if(A == null || B == null) return false;
        return recur(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode nodeA, TreeNode nodeB){
        if(nodeB == null) return true;
        if(nodeA == null || nodeA.val != nodeB.val) return false;
        return recur(nodeA.left, nodeB.left) && recur(nodeA.right, nodeB.right);
    }
}
