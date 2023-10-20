//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 54{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 54().new Solution();
//
//
//        }
//
//
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    int res, k;
//
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        // 倒序遍历
//        dfs(root.right);
//        // 中序遍历
//        if (k == 0) return;
//        // 每一次中序遍历k都自减1，直到k==0，这说明找到了
//        if (--k == 0) res = root.val;
//        dfs(root.left);
//    }
//}
//
////leetcode submit region end(Prohibit modification and deletion)
//
//}