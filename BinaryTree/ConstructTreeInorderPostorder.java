package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeInorderPostorder {
    private int postorderIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length -1;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return arrayToTree(postorder, 0, inorder.length -1);
    }

    public TreeNode arrayToTree(int[] postorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);

        postorderIndex--;

        int inorderRootIndex = inorderMap.get(rootValue);

        root.right = arrayToTree(postorder, inorderRootIndex +1, rightIndex);
        root.left = arrayToTree(postorder, leftIndex, inorderRootIndex -1);

        return root;
    }
}
