package BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZagLevels = new ArrayList<>();
        if (root == null) {
            return zigZagLevels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight = true;

        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < numNodes; i++) {
                TreeNode node = queue.remove();

                if (isLeftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            zigZagLevels.add(level);
            isLeftToRight = !isLeftToRight;
        }
        return zigZagLevels;
    }
}
