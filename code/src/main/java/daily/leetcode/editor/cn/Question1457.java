package daily.leetcode.editor.cn;

import java.util.*;

public class Question1457 {
    public static void main(String[] args) {
        Solution solution = new Question1457().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */


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

    /**
     * 执行耗时:7 ms,击败了95.00% 的Java用户
     * 内存消耗:67.4 MB,击败了40.55% 的Java用户
     */
    class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            if (root == null) return 0;
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int k) {
            int res = 0;
            // 左移val次，然后异或
            // 偶数次出现则会置为0，奇数次出现则为1
            int n = k ^ (1 << root.val);
            // 到达叶子节点时
            if (root.left == null && root.right == null) {
                // 回文判断
                // n==0判断回文串为偶数长度的情况下,所有二进制位是否都为0
                // n&(n-1)判断奇数情况下是否只有一个二进制位为1
                if (n == 0 || (n & (n - 1)) == 0) {
                    return 1;
                }
            }
            // 继续遍历左右树
            if (root.left != null) {
                res += dfs(root.left, n);
            }
            if (root.right != null) {
                res += dfs(root.right, n);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}