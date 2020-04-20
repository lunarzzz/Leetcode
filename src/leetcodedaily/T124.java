package leetcodedaily;

import common.TreeNode;

public class T124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        depth(root);
        return max;
    }

    /**
     * 计算单条子树路径的和
     */
    int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int curr = root.val + (left>0?left:0) + (right>0?right:0);
        max = Math.max(max, curr);
        return root.val + Math.max(Math.max(left, right), 0 );
    }
}
