package BinaryTree;

public class MaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculatePathSum(root);
        return maxSum;
    }

    public int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(calculatePathSum(node.left), 0);
        int right = Math.max(calculatePathSum(node.right), 0);

        int pathSum = node.val + left + right;

        maxSum = Math.max(maxSum, pathSum);

        return node.val + Math.max(left, right);
    }
}
