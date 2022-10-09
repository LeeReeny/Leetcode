import DataStructure.TreeNode;

import java.util.HashMap;

public class BuildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            hash.put(inorder[i], i);
        }
        return recurBuildTree(hash, preorder, 0, preorder.length-1, 0);
    }

    public TreeNode recurBuildTree(HashMap<Integer, Integer> hash, int[] preorder, int s0, int e0, int s1){
        if(s0 > e0) return null;
        int mid = preorder[s1], idx = hash.get(mid), leftLen = idx-s0-1;
        TreeNode node = new TreeNode(mid);
        node.left = recurBuildTree(hash, preorder, s0, idx-1, s1+1);
        node.right = recurBuildTree(hash, preorder, idx+1, e0, s1+2+leftLen);
        return node;
    }
}
