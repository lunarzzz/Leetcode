package leetcodedaily;

public class T543 {
    int max= 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    /**
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = root.left == null ? 0 : depth(root.left ) +1;
        int right = root.right == null ? 0 : depth(root.right ) +1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
