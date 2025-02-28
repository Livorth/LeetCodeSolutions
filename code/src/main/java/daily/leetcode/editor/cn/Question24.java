package daily.leetcode.editor.cn;

public class Question24 {
    public static void main(String[] args) {
        Solution solution = new Question24().new Solution();


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
     * 内存消耗:40.5 MB,击败了14.41% 的Java用户
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            return reverseKGroup(head, 2);
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode newHead = new ListNode(0, head);
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            if (count < k) return newHead.next;
            ListNode pre = newHead;
            ListNode cur = pre.next;
            for (int i = 0; i < count / k; i++) {
                for (int j = 0; j < k - 1; j++) {
                    // 头插法，pre不动，cur后移（不断将cur.next放到pre后）
                    ListNode next = cur.next;
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                }
                // 分段重置
                pre = cur;
                cur = cur.next;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}