class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    level.add(null);
                    continue;
                }

                level.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }

            int l = 0, r = level.size() - 1;
            while (l < r) {
                if (!Objects.equals(level.get(l), level.get(r)))
                    return false;
                l++;
                r--;
            }

            boolean hasNode = false;
            for (TreeNode node : queue) {
                if (node != null) {
                    hasNode = true;
                    break;
                }
            }

            if (!hasNode) break;
        }

        return true;
    }
}