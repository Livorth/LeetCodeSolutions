package daily.leetcode.editor.cn;

import java.util.*;

public class Question1726 {
    public static void main(String[] args) {
        Solution solution = new Question1726().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            // 求出所有可能的乘积结果
            for (int i = 1; i < nums.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    int x = nums[i] * nums[j];
                    countMap.merge(x, 1, Integer::sum);
                }
            }
            int ans = 0;
            for (int v : countMap.values()) {
                // 多个里边选两个，排列组合，C(2,n)
                ans += v * (v - 1) / 2;
            }
            return ans * 8;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}