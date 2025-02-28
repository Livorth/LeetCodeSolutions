package daily.leetcode.editor.cn;

public class Question1290 {
    public static void main(String[] args) {
        Solution solution = new Question1290().new Solution();


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.2 MB,击败了37.07% 的Java用户
     */
    class Solution {
        public int getDecimalValue(ListNode head) {
            int res = head.val;
            while (head.next != null) {
                res = res * 2 + head.next.val;
                head = head.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}