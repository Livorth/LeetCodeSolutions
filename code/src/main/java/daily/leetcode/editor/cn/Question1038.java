package daily.leetcode.editor.cn;

import java.util.*;

public class Question1038 {
    public static void main(String[] args) {
        Solution solution = new Question1038().new Solution();


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了38.50% 的Java用户
     */
    class Solution {
        // sum维护当期节点右数节点大小和
        private int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}