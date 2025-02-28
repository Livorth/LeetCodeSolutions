package daily.leetcode.editor.cn;

public class Question19 {
    public static void main(String[] args) {
        Solution solution = new Question19().new Solution();


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
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了34.83% 的Java用户
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode(0);
            node.next = head;
            ListNode n1 = node;
            ListNode n2 = node;
            // n1先走n
            while (n > 0) {
                n1 = n1.next;
                n--;
            }
            // n2也开始走，直到n1走到底
            while (n1.next != null) {
                n1 = n1.next;
                n2 = n2.next;
            }
            n2.next = n2.next.next;
            return node.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}