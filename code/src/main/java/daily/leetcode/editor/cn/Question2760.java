package daily.leetcode.editor.cn;

import java.util.*;

public class Question2760 {
    public static void main(String[] args) {
        Solution solution = new Question2760().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int n = nums.length;
            int ans = 0, i = 0;
            while (i < n) {
                // 满足条件1与3
                if (nums[i] > threshold || nums[i] % 2 != 0) {
                    i++;
                    continue;
                }
                // 开始记录子数组
                int start = i++;
                // 满足条件2,3
                while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                    i++;
                }
                ans = Math.max(ans, i - start);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}