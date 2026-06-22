class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> processQueue = new ArrayDeque<>();

        queue.offer(root);
        processQueue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode processor = processQueue.poll();

            TreeNode temp = processor.left;
            processor.left = processor.right;
            processor.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
                processQueue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
                processQueue.offer(current.right);
            }
        }

        return root;
    }
}
