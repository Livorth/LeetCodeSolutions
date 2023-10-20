//package swordOffer.leetcode.editor.cn;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class SwordOffer322 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer322().new Solution();
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
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//    /**
//     * 	执行耗时:0 ms,击败了100.00% 的Java用户
//     * 	内存消耗:41.6 MB,击败了47.71% 的Java用户
//     */
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            LinkedList<TreeNode> queue = new LinkedList();
//            List<List<Integer>> ans = new LinkedList();
//            if (root == null) {
//                return ans;
//            }
//            queue.add(root);
//            int index = 0;
//            // BFS
//            while (queue.size() != 0) {
//                int size = queue.size();
//                ArrayList<Integer> list = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    TreeNode temp = queue.removeFirst();
//                    list.add(temp.val);
//                    if (temp.left != null) queue.add(temp.left);
//                    if (temp.right != null) queue.add(temp.right);
//                }
//                ans.add(list);
//            }
//            return ans;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}