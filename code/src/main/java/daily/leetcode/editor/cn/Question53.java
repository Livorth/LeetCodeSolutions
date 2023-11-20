package daily.leetcode.editor.cn;

import java.util.*;

public class Question53 {
    public static void main(String[] args) {
        Solution solution = new Question53().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动态规划，判断是否需要续上之前的子数组
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:58.4 MB,击败了5.00% 的Java用户
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int num : nums) {
                // 是否续上之前的子数组
                sum = Math.max(num, sum + num);
                res = Math.max(res, sum);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}