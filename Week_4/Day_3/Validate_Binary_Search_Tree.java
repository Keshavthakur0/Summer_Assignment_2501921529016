class Solution {
    public boolean isValidBST(TreeNode root) {
        long prev = Long.MIN_VALUE;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                if (curr.val <= prev) return false;
                prev = curr.val;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;

                    if (curr.val <= prev) return false;
                    prev = curr.val;

                    curr = curr.right;
                }
            }
        }

        return true;
    }
}