package daily.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class Question862 {
    public static void main(String[] args) {
        Solution solution = new Question862().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] preSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            int[] q = new int[n + 1];
            int head = 0, tail = -1;
            int res = n + 1;
            for (int i = 0; i <= n; i++) {
                long curSum = preSum[i];
                while (head <= tail && curSum - preSum[q[head]] >= k) {
                    res = Math.min(res, i - q[head++]);
                }
                while (head <= tail && preSum[q[tail]] >= curSum) {
                    tail--;
                }
                q[++tail] = i;
            }
            return res < n + 1 ? res : -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}