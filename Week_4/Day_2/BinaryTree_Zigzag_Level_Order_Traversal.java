class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();

        boolean leftToRight = true;
        curr.push(root);

        while (!curr.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while (!curr.isEmpty()) {
                TreeNode node = curr.pop();
                level.add(node.val);

                if (leftToRight) {
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                } else {
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                }
            }

            result.add(level);

            Stack<TreeNode> temp = curr;
            curr = next;
            next = temp;

            leftToRight = !leftToRight;
        }

        return result;
    }
}