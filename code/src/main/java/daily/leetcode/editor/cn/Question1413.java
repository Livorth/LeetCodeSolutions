package daily.leetcode.editor.cn;

import java.util.*;

public class Question1413 {
    public static void main(String[] args) {
        Solution solution = new Question1413().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            int n = nums.length, min = Integer.MAX_VALUE;
            // 记录前缀和
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = count + nums[i];
                min = Math.min(min, count);
            }
            // 必须要满足大于1，所以需要时1-min
            return min < 1 ? 1 - min : 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}