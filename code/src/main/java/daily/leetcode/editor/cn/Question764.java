package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question764 {
    public static void main(String[] args) {
        Solution solution = new Question764().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            // 以(i,j)为中心最大的阶数
            int[][] dp = new int[n][n];
            // 初始化，全部置为最大，但将mines中的点置为0
            for (int[] e : dp) Arrays.fill(e, n);
            for (int[] e : mines) dp[e[0]][e[1]] = 0;

            for (int i = 0; i < n; ++i) {
                // 记录4个方向的连续1的最大个数
                int left = 0, right = 0, up = 0, down = 0;
                for (int j = 0, k = n - 1; j < n; ++j, --k) {
                    // 非0则加1，为0则置0
                    left = dp[i][j] > 0 ? left + 1 : 0;
                    right = dp[i][k] > 0 ? right + 1 : 0;
                    up = dp[j][i] > 0 ? up + 1 : 0;
                    down = dp[k][i] > 0 ? down + 1 : 0;
                    // i,j 相当于先从上到下，再从左到右，即左支
                    dp[i][j] = Math.min(dp[i][j], left);
                    // i,k 相当于先从上到下，再从右到左，即右支
                    dp[i][k] = Math.min(dp[i][k], right);
                    // j,i 相当于先从左到右，再从上到下，即上支
                    dp[j][i] = Math.min(dp[j][i], up);
                    // k,i 相当于先从左到右，再从下到上，即下支
                    dp[k][i] = Math.min(dp[k][i], down);
                }
            }
            int res = 0;
            for (int[] e : dp) {
                // 获取到最大的值
                res = Math.max(res, Arrays.stream(e).max().getAsInt());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}