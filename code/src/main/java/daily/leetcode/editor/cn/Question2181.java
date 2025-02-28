package daily.leetcode.editor.cn;

public class Question2181 {
    public static void main(String[] args) {
        Solution solution = new Question2181().new Solution();


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
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * 执行耗时:5 ms,击败了99.51% 的Java用户
     * 内存消耗:86.7 MB,击败了5.51% 的Java用户
     */
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode node = head;
            while (node != null) {
                while (node.next != null && node.next.val != 0) {
                    node.val += node.next.val;
                    node.next = node.next.next;
                }
                node.next = node.next.next;
                node = node.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}