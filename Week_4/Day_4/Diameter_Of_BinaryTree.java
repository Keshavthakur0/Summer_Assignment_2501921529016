import java.util.*;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        Pair first = bfs(root, graph);
        Pair second = bfs(first.node, graph);

        return second.distance;
    }

    private void buildGraph(TreeNode node, TreeNode parent,
                            Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node, new ArrayList<>());

        if (parent != null) {
            graph.get(node).add(parent);

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(node);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    private Pair bfs(TreeNode start,
                     Map<TreeNode, List<TreeNode>> graph) {

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        TreeNode farthest = start;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                farthest = curr;

                for (TreeNode next : graph.get(curr)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            if (!queue.isEmpty()) {
                distance++;
            }
        }

        return new Pair(farthest, distance);
    }

    static class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}