package daily.leetcode.editor.cn;

import java.util.*;

public class Question687 {
    public static void main(String[] args) {
        Solution solution = new Question687().new Solution();


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

    class Solution {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return max;
        }

        int dfs(TreeNode root) {
            if (root == null) return 0;
            // ans存储当前节点下左右子树中更长的路径
            // cur存储经过当前节点与左右子树的路径长
            int ans = 0, cur = 0;
            // 通过递归获取左右子树所包含的最长路径
            int l = dfs(root.left), r = dfs(root.right);
            // 左子树与当前节点值相同，则将当前节点添加进路径中
            if (root.left != null && root.left.val == root.val) {
                ans = l + 1;
                cur += l + 1;
            }
            // 由子树与当前节点值相同，则比较左右子树谁的路径更长
            if (root.right != null && root.right.val == root.val) {
                ans = Math.max(ans, r + 1);
                cur += r + 1;
            }
            // 如果当前节点无法与任意一个左右子节点相同，则无法将当前节点纳入最长路径的考虑范畴
            max = Math.max(max, cur);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}