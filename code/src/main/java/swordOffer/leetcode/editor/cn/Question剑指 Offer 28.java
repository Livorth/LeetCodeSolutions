//package swordOffer.leetcode.editor.cn;
//
//public class swordOffer28 {
//    public static void main(String[] args) {
//        Solution solution = new swordOffer28().new Solution();
//
//
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
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
//
//    class Solution {
//        public boolean isSymmetric(TreeNode root) {
//            return root == null ? true : dfs(root.left, root.right);
//        }
//        private boolean dfs(TreeNode left, TreeNode right){
//            // 两边同时为空即为空，即对称
//            if(left == null && right == null) return true;
//            // 单侧为空或者两值不相等，即不对称
//            if(left == null || right == null || left.val != right.val) return false;
//            // 递归left的左节点与right的右节点，left的右节点与right的左节点
//            return dfs(left.left, right.right) && dfs(left.right, right.left);
//        }
//    }
//
////leetcode submit region end(Prohibit modification and deletion)
//
//}