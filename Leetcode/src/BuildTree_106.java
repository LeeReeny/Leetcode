import DataStructure.TreeNode;

import java.util.HashMap;

public class BuildTree_106 {
    public TreeNode buildTress(int[] inorder, int[] postorder){
        if(inorder.length == 0) return null;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            hash.put(inorder[i], i);
        }
        return recurBuild(hash, postorder, 0, postorder.length-1, postorder.length-1);
    }

    public TreeNode recurBuild(HashMap<Integer, Integer> hash, int[] postorder, int s0, int e0, int s1){
        if(s0 > e0) return null;
        int mid = postorder[s1], idx = hash.get(mid), rightlen = e0-idx-1;
        TreeNode node = new TreeNode(mid);
        node.right = recurBuild(hash, postorder, idx+1, e0, s1-1);
        node.left = recurBuild(hash, postorder, s0, idx-1, s1-rightlen-2);
        return node;
    }
}
