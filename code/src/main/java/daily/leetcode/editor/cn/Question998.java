package daily.leetcode.editor.cn;

import java.util.*;

public class Question998 {
    public static void main(String[] args) {
        Solution solution = new Question998().new Solution();


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
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            // 出现根节点为空的情况，或者根节点的值比当前值更小，则当前节点可以作为个根节点
            if (root == null || root.val < val) {
                return new TreeNode(val, root, null);
            }
            // 反之则可以继续往下递归
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}