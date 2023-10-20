package daily.leetcode.editor.cn;

import java.util.*;

public class Question2280 {
    public static void main(String[] args) {
        Solution solution = new Question2280().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLines(int[][] prices) {
            int res = 1;
            Arrays.sort(prices, (a, b) -> {
                return a[0] - b[0];
            });
            if (prices.length <= 1) return 0;
            if (prices.length <= 2) return res;
            for (int i = 0; i < prices.length - 2; i++) {
                int k1 = (prices[i][1] - prices[i + 1][1]) * (prices[i + 1][0] - prices[i + 2][0]);
                int k2 = (prices[i + 1][1] - prices[i + 2][1]) * (prices[i][0] - prices[i + 1][0]);
                if (k1 != k2) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}