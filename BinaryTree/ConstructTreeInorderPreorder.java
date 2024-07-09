package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeInorderPreorder {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < preorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTreeRecursive(preorder, 0, inorder.length -1);
    }

    public TreeNode arrayToTreeRecursive(int[] preorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        preorderIndex++;

        int inorderRootIndex = inorderIndexMap.get(rootValue);

        root.left = arrayToTreeRecursive(preorder, leftIndex, inorderRootIndex -1);

        root.right = arrayToTreeRecursive(preorder, inorderRootIndex +1, rightIndex);

        return root;
    }
}
