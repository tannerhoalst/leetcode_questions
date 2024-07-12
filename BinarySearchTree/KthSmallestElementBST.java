package BinarySearchTree;

public class KthSmallestElementBST {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        findKthSmallest(root, k);
        return result;
    }

    public void findKthSmallest(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        findKthSmallest(node.left, k);
        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        findKthSmallest(node.right, k);
    }
}
