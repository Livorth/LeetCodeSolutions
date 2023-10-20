//package swordOffer.leetcode.editor.cn;
//
//public class SwordOffer06 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer06().new Solution();
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
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//
//    class Solution {
//        int[] res;
//        int i = 0;
//        int j = 0;
//
//        public int[] reversePrint(ListNode head) {
//            solve(head);
//            return res;
//        }
//
//        public void solve(ListNode head) {
//            // 递归到了链表末尾，构建结果数组
//            if (head == null) {
//                res = new int[i];
//                return;
//            }
//            // 在递归填数之前使用i统计链表的长度
//            i++;
//            // 往下递归
//            solve(head.next);
//            // 在递归往回退的时候将结果填入结果数组
//            res[j++] = head.val;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}