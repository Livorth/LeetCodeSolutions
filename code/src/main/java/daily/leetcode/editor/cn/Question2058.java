package daily.leetcode.editor.cn;

public class Question2058 {
    public static void main(String[] args) {
        Solution solution = new Question2058().new Solution();


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
     * 执行耗时:5 ms,击败了78.11% 的Java用户
     * 内存消耗:59.4 MB,击败了37.69% 的Java用户
     */
    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int res[] = new int[]{100086, -1};
            int first = -1;
            int last = -1;
            int dth = 0;
            while (head.next != null && head.next.next != null) {
                if (head.val < head.next.val && head.next.val > head.next.next.val || head.val > head.next.val && head.next.val < head.next.next.val) {
                    if (first == -1) {
                        first = dth;
                    }
                    if (last == -1) {
                        last = dth;
                    } else {
                        res[1] = dth - first;
                        res[0] = Math.min(res[0], dth - last);
                        last = dth;
                    }
                }
                dth++;
                head = head.next;
            }
            if (res[0] == 100086) res[0] = -1;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}