package daily.leetcode.editor.cn;

import java.util.PriorityQueue;

public class Question23 {
    public static void main(String[] args) {
        Solution solution = new Question23().new Solution();


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
     * 执行耗时:4 ms,击败了67.80% 的Java用户
     * 内存消耗:43.5 MB,击败了43.54% 的Java用户
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = new ListNode();
            ListNode cur = head;
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (ListNode list : lists) {
                if (list != null) {
                    queue.add(list);
                }
            }
            while (!queue.isEmpty()) {
                ListNode poll = queue.poll();
                cur.next = poll;
                cur = cur.next;
                if (poll.next != null) {
                    queue.add(poll.next);
                }
            }

            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}