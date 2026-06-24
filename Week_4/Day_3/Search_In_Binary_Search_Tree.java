class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        for (TreeNode curr = root; curr != null; ) {
            if (curr.val == val) return curr;
            curr = (val < curr.val) ? curr.left : curr.right;
        }
        return null;
    }
}