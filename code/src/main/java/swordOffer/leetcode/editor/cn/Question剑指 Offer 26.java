//package swordOffer.leetcode.editor.cn;
//
//public class swordOffer26 {
//    public static void main(String[] args) {
//        Solution solution = new swordOffer26().new Solution();
//
//
//
//    }
//
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//
//
//    class Solution {
//        public boolean isSubStructure(TreeNode A, TreeNode B) {
//            return (A != null && B != null) &&
//                    // dfs用于判断是否当前节点为起点，后续的节点是否与B一直
//                    // isSubStructure递归则是分别将A的左右子节点作为起点进行dfs
//                    (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
//        }
//        boolean dfs(TreeNode A, TreeNode B) {
//            if(B == null) return true;
//            if(A == null || A.val != B.val) return false;
//            return dfs(A.left, B.left) && dfs(A.right, B.right);
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}