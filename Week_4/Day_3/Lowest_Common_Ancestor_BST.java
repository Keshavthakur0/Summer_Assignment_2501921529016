class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);

        TreeNode lca = null;
        int i = 0;

        while (i < pathP.size() && i < pathQ.size()) {
            if (pathP.get(i) != pathQ.get(i)) {
                break;
            }
            lca = pathP.get(i);
            i++;
        }

        return lca;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();

        while (root != null) {
            path.add(root);

            if (root.val == target.val) {
                break;
            }

            root = target.val < root.val ? root.left : root.right;
        }

        return path;
    }
}