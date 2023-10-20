//package swordOffer.leetcode.editor.cn;
//
//import java.util.*;
//
//public class SwordOffer323 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer323().new Solution();
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
//     * 	执行耗时:1 ms,击败了96.33% 的Java用户
//     * 	内存消耗:41.3 MB,击败了87.49% 的Java用户
//     */
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            LinkedList<TreeNode> queue = new LinkedList();
//            List<List<Integer>> ans = new LinkedList();
//            if (root == null) {
//                return ans;
//            }
//            queue.add(root);
//            int level = 0;
//            // BFS
//            while (queue.size() != 0) {
//                int size = queue.size();
//                ArrayList<Integer> list = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    TreeNode temp = queue.removeFirst();
//                    if(level % 2 == 0) list.add(temp.val);
//                    else list.add(0, temp.val);
//                    if (temp.left != null) queue.add(temp.left);
//                    if (temp.right != null) queue.add(temp.right);
//                }
//                ans.add(list);
//                level++;
//            }
//            return ans;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}