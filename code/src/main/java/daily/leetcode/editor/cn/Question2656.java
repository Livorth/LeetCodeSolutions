package daily.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Stream;

public class Question2656 {
    public static void main(String[] args) {
        Solution solution = new Question2656().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:4 ms,击败了56.19% 的Java用户
     * 内存消耗:42.5 MB,击败了65.84% 的Java用户
     */
    class Solution {
        public int maximizeSum(int[] nums, int k) {
            int i = Arrays.stream(nums).max().getAsInt();
            return (i + i + k - 1) * k / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}