public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        Map<TreeNode, Integer> idMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        idMap.put(root, 0);
        queue.offer(root);

        StringBuilder sb = new StringBuilder();
        int nextId = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            int left = -1;
            int right = -1;

            if (curr.left != null) {
                left = nextId;
                idMap.put(curr.left, nextId++);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                right = nextId;
                idMap.put(curr.right, nextId++);
                queue.offer(curr.right);
            }

            sb.append(idMap.get(curr))
              .append(",")
              .append(curr.val)
              .append(",")
              .append(left)
              .append(",")
              .append(right)
              .append(";");
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] rows = data.split(";");
        int n = rows.length;

        TreeNode[] nodes = new TreeNode[n];
        int[][] child = new int[n][2];

        for (String row : rows) {
            String[] p = row.split(",");

            int id = Integer.parseInt(p[0]);
            int val = Integer.parseInt(p[1]);

            nodes[id] = new TreeNode(val);
            child[id][0] = Integer.parseInt(p[2]);
            child[id][1] = Integer.parseInt(p[3]);
        }

        for (int i = 0; i < n; i++) {
            if (child[i][0] != -1)
                nodes[i].left = nodes[child[i][0]];

            if (child[i][1] != -1)
                nodes[i].right = nodes[child[i][1]];
        }

        return nodes[0];
    }
}