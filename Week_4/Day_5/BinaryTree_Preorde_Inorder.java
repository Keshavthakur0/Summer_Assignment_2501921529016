class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int inorderIndex = 0;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            if (stack.peek().val != inorder[inorderIndex]) {
                stack.peek().left = node;
                stack.push(node);
            } else {
                TreeNode parent = null;

                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    parent = stack.pop();
                    inorderIndex++;
                }

                parent.right = node;
                stack.push(node);
            }
        }

        return root;
    }
}