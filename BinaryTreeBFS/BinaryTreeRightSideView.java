package BinaryTreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class BinaryTreeRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewValues = new LinkedList<>();
        if (root == null) {
            return rightViewValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int numNodes = queue.size();

            for (int i = 0; i < numNodes; i++) {
                TreeNode node = queue.remove();

                if (i == numNodes -1) {
                    rightViewValues.add(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        return rightViewValues;
    }
}
