class Solution {
    public int maxDepth(TreeNode root) {
      int maxDepth = 0;
        int currentDepth = 0;
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {

                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
                current = current.right;
            } else {
  
                TreeNode predecessor = current.left;
                int deltaDepth = 1;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                    deltaDepth++;
                }

                if (predecessor.right == null) {
     
                    predecessor.right = current;
                    currentDepth++;
                    maxDepth = Math.max(maxDepth, currentDepth);
                    current = current.left;
                } else {

                    predecessor.right = null;
                    currentDepth -= deltaDepth; 
                    current = current.right;
                }
            }
        }
        return maxDepth;  
    }
}