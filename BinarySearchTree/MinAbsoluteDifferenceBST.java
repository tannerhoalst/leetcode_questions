package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MinAbsoluteDifferenceBST {
        private Integer prevVal;
    private int minAbsDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        findMinAbsDiference(root);
        return minAbsDifference;
    }

    public void findMinAbsDiference(TreeNode node) {
        if (node == null) {
            return;
        }

        findMinAbsDiference(node.left);

        if (prevVal != null) {
            minAbsDifference = Math.min(minAbsDifference, node.val - prevVal);
        }
        prevVal = node.val;

        findMinAbsDiference(node.right);
    }
}
