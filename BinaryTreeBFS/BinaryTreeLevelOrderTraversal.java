package BinaryTreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if (root == null) {
            return levelOrder;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < numNodes; i++) {
                TreeNode node = queue.remove();

                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}
