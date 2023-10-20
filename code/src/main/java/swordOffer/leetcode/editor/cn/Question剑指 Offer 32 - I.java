//package swordOffer.leetcode.editor.cn;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class SwordOffer321 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer321().new Solution();
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
//    class Solution1 {
//        public int[] levelOrder(TreeNode root) {
//            if (root == null) return new int[0];
//            Queue<TreeNode> queue = new LinkedList<>();
//            List<Integer> ans = new ArrayList<>();
//            queue.add(root);
//            ans.add(root.val);
//            // 进行一个BFS
//            while (!queue.isEmpty()) {
//                // 常规BFS操作
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = queue.poll();
//                    if (node.left != null) {
//                        queue.add(node.left);
//                        ans.add(node.left.val);
//                    }
//                    if (node.right != null) {
//                        queue.add(node.right);
//                        ans.add(node.right.val);
//                    }
//                }
//            }
//            return ans.stream().mapToInt(Integer::valueOf).toArray();
//        }
//    }
//
//    /**
//     * 	执行耗时:0 ms,击败了100.00% 的Java用户
//     * 	内存消耗:41.3 MB,击败了59.27% 的Java用户
//     */
//    class Solution {
//        public int[] levelOrder(TreeNode root) {
//            LinkedList<TreeNode> queue = new LinkedList();
//            LinkedList<Integer> ans = new LinkedList();
//            if (root == null) {
//                return new int[0];
//            }
//            queue.add(root);
//            // BFS
//            while (queue.size() != 0) {
//                TreeNode temp = queue.removeFirst();
//                ans.add(temp.val);
//                if (temp.left != null) queue.add(temp.left);
//                if (temp.right != null) queue.add(temp.right);
//            }
//            int[] r = new int[ans.size()];
//            for (int i = 0; i < r.length; i++) {
//                r[i] = ans.removeFirst();
//            }
//            return r;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}