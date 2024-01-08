package daily.leetcode.editor.cn;

import java.util.*;

public class Question1793 {
    public static void main(String[] args) {
        Solution solution = new Question1793().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双指针
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:56.5 MB,击败了14.47% 的Java用户
     */
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int res = 0;
            int r = k, l = k;
            int flag = nums[k];
            while (true) {
                // 求出flag为最小值的范围，并更新结果
                while (r < nums.length && nums[r] >= flag) r++;
                while (l >= 0 && nums[l] >= flag) l--;
                res = Math.max(res, (r - l - 1) * flag);

                if (l < 0 && r >= nums.length) break;
                // 更新flag
                if (l >= 0 && r < nums.length) {
                    // 选较大的是因为nums[l], nums[r]都比flag要小，如果直接选更小的那个，就会漏掉中间一个没算
                    flag = Math.max(nums[l], nums[r]);
                } else if (l < 0) {
                    flag = nums[r];
                } else {
                    flag = nums[l];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}