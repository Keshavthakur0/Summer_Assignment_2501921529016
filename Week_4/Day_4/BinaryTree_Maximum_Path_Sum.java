import java.util.*;

class Solution {
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> down = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        int ans = Integer.MIN_VALUE;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.peek();

            if (node.right != null && node.right != prev) {
                curr = node.right;
            } else {
                stack.pop();

                int left = Math.max(0, down.getOrDefault(node.left, 0));
                int right = Math.max(0, down.getOrDefault(node.right, 0));

                ans = Math.max(ans, node.val + left + right);

                down.put(node, node.val + Math.max(left, right));

                prev = node;
            }
        }

        return ans;
    }
}