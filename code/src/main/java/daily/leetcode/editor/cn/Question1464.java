package daily.leetcode.editor.cn;

import java.util.*;

public class Question1464 {
    public static void main(String[] args) {
        Solution solution = new Question1464().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max1) {
                    max2 = max1;
                    max1 = nums[i];
                }
                else if (nums[i] > max2) {
                    max2 = nums[i];
                }
            }
            return (max1 - 1) * (max2 - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
