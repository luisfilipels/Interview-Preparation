import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    static public class TreeNode {
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

    static class NodeLevelTuple {
        TreeNode node;
        int level;

        NodeLevelTuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static List<Double> averageOfLevels (TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Long> nodesPerLevel = new ArrayList<>();
        List<Long> sumPerLevel = new ArrayList<>();

        Queue<NodeLevelTuple> queue = new ArrayDeque<>();
        queue.add(new NodeLevelTuple(root, 0));

        while(!queue.isEmpty()){
            NodeLevelTuple current = queue.poll();
            if (nodesPerLevel.size() <= current.level) {
                nodesPerLevel.add(1L);
                sumPerLevel.add((long)current.node.val);
            } else {
                nodesPerLevel.set(current.level, nodesPerLevel.get(current.level) + 1);
                sumPerLevel.set(current.level, sumPerLevel.get(current.level) + current.node.val);
            }
            if (current.node.left != null) queue.add(new NodeLevelTuple(current.node.left, current.level+1));
            if (current.node.right != null) queue.add(new NodeLevelTuple(current.node.right, current.level+1));
        }

        List<Double> returnList = new ArrayList<>();
        for (int i = 0; i < nodesPerLevel.size(); i++) {
            returnList.add((double)sumPerLevel.get(i) / nodesPerLevel.get(i));
        }
        return returnList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(averageOfLevels(root));
    }

}
