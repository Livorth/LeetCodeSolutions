package daily.leetcode.editor.cn;

import java.util.*;

public class Question2342 {
    public static void main(String[] args) {
        Solution solution = new Question2342().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表存储，用numSum[i]中存当前数位和为i的最大数
     * 一边遍历，一边更新结果以及数位和为i的最大数
     * 执行耗时:21 ms,击败了99.67% 的Java用户
     * 内存消耗:56 MB,击败了53.85% 的Java用户
     */
    class Solution {
        public int maximumSum(int[] nums) {
            int res = -1;
            // 数位最大为9*9,numSum[i]中存当前数位和为i的最大数
            int[] numSum = new int[82];

            for (int num : nums) {
                int sum = 0;
                for (int i = num; i > 0; i /= 10) {
                    sum += i % 10;
                }
                // 当前已经存在数位和为sum的数据，则更新结果
                if (numSum[sum] != 0) {
                    res = Math.max(res, numSum[sum] + num);
                }
                // 更新数位和为sum的最大数
                numSum[sum] = Math.max(numSum[sum], num);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}