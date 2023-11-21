package daily.leetcode.editor.cn;

import java.util.*;

public class Question2216 {
    public static void main(String[] args) {
        Solution solution = new Question2216().new Solution();
        solution.minDeletion(new int[]{1, 1, 2, 2, 3, 3});

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心
     * 执行耗时:3 ms,击败了58.59% 的Java用户
     * 内存消耗:56.3 MB,击败了18.18% 的Java用户
     */
    class Solution {
        public int minDeletion(int[] nums) {
            int n = nums.length;
            int res = 0;
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (k % 2 == 0 && i + 1 < n && nums[i] == nums[i + 1]) {
                    res++;
                } else {
                    k++;
                }
            }
            return k % 2 == 0 ? res : res + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}