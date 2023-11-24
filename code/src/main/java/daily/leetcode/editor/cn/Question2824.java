package daily.leetcode.editor.cn;

import java.util.*;

public class Question2824 {
    public static void main(String[] args) {
        Solution solution = new Question2824().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:2 ms,击败了96.22% 的Java用户
     * 内存消耗:40.4 MB,击败了5.61% 的Java用户
     */
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            int res = 0;
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    if (nums.get(i) + nums.get(j) < target) res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}