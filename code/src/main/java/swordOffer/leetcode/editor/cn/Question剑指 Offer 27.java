//package swordOffer.leetcode.editor.cn;
//
//public class swordOffer27 {
//    public static void main(String[] args) {
//        Solution solution = new swordOffer27().new Solution();
//
//
//    }
//
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//
//    /**
//     * 	执行耗时:0 ms,击败了100.00% 的Java用户
//     * 	内存消耗:38.8 MB,击败了75.74% 的Java用户
//     */
//    class Solution {
//        public TreeNode mirrorTree(TreeNode root) {
//            if (root == null) return null;
//            dfs(root);
//            return root;
//        }
//
//        public void dfs(TreeNode root) {
//            if (root == null) return;
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//            dfs(root.left);
//            dfs(root.right);
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}