//package swordOffer.leetcode.editor.cn;
//
//public class SwordOffer35 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer35().new Solution();
//
//
//    }
//
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            return recur(head, null);
//        }
//
//        private ListNode recur(ListNode cur, ListNode pre) {
//            // 在递归到底后返回
//            if (cur == null) return pre;
//            // 递归获取后继节点
//            ListNode res = recur(cur.next, cur);
//            // 反转
//            cur.next = pre;
//            // 反转后的头节点
//            return res;
//        }
//    }
//
////leetcode submit region end(Prohibit modification and deletion)
//
//}