package BinaryTreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
        public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAverages = new LinkedList<>();
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            double levelSum = 0;

            for (int i = 0; i < numNodes; i++) {
                TreeNode node = queue.remove();
                levelSum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            levelAverages.add(levelSum / numNodes);
        }

        return levelAverages;
    }
}
