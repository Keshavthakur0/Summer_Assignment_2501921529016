class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       return serialize(p).equals(serialize(q));
    }

    private String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();  
    }
}