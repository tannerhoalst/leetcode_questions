package BinaryTree;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }

    public int calculateSum(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum *= 10;
        currentSum += root.val;

        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return calculateSum(root.left, currentSum) + calculateSum(root.right, currentSum);
    }
}
