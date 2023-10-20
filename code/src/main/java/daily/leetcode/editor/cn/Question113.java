package swordOffer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Question113 {
    public static void main(String[] args) {
        Solution solution = new Question113().new Solution();


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
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> node = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return ans;
        }

        private void dfs(TreeNode root, int targetSum) {
            if (root == null) return;
            node.add(root.val);
            if (root.left == null && root.right == null && root.val == targetSum) {
                ans.add(new ArrayList<>(node));
            }
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
            node.remove(node.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}