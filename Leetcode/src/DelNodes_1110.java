import DataStructure.TreeNode;

import java.util.*;

public class DelNodes_1110 {
    List<TreeNode> forest;
    Set<Integer> deleteSet;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete){
        forest = new ArrayList<>();
        deleteSet = new HashSet<>();
        for(int n : to_delete) deleteSet.add(n);

        root = recurDelete(root);
        if(root != null) forest.add(root);
        return forest;
    }

    public TreeNode recurDelete(TreeNode node){
        if(node == null) return node;

        node.left = recurDelete(node.left);
        node.right = recurDelete(node.right);
        if(deleteSet.contains(node.val)){
            if(node.left != null) forest.add(node.left);
            if(node.right != null) forest.add(node.right);
            node = null;
        }
        return node;

    }

}
