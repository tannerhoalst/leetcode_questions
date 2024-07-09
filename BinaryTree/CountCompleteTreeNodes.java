package BinaryTree;

public class CountCompleteTreeNodes {
    private int count; 

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countNodes(root.left);
        countNodes(root.right);

        count++;
        return count;
    }
}
