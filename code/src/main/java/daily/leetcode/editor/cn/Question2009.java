package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question2009 {
    public static void main(String[] args) {
        Solution solution = new Question2009().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:38 ms,击败了100.00% 的Java用户
     * 内存消耗:55.3 MB,击败了76.09% 的Java用户
     */
    class Solution {
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int len = 1;
            // 去重
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[len++] = nums[i];
                }
            }

            int ans = 0;
            int left = 0;
            // 枚举右边界
            for (int right = 0; right < len; right++) {
                // 左边界收缩，滑动窗口的值以右边界为准，差等于nums.length-1
                while (nums[left] < nums[right] - nums.length + 1) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return nums.length - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}