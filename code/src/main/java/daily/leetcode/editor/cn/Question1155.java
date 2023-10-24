package daily.leetcode.editor.cn;

import java.util.*;

public class Question1155 {
    public static void main(String[] args) {
        Solution solution = new Question1155().new Solution();

        System.out.println(solution.numRollsToTarget(1, 6, 3));
        System.out.println(solution.numRollsToTarget(2, 6, 7));
        System.out.println(solution.numRollsToTarget(30, 30, 500));
        System.out.println(solution.numRollsToTarget(5, 10, 32));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:2 ms,击败了98.04% 的Java用户
     * 内存消耗:39.7 MB,击败了40.78% 的Java用户
     */
    class Solution {
        private static final int MOD = 1_000_000_007;
        int[][] memo = null;

        public int numRollsToTarget(int n, int k, int target) {
            if (memo == null) memo = new int[n + 1][target + 1];
            if (target < n || target > n * k) return 0;
            if (n == 0 && target == 0) return 1;
            if (n == 0 || target == 0) return 0;
            int res = 0;
            for (int num = 1; num <= k && num <= target; num++) {
                int orDefault = memo[n - 1][target - num];
                if (orDefault != 0) {
                    res = (res + orDefault) % MOD;
                } else {
                    // 递归，找(n-1)个骰子，达到(target-num)的种数
                    res = (res + numRollsToTarget(n - 1, k, target - num)) % MOD;
                }
            }
            // 记忆化
            memo[n][target] = res;
            return res;
        }
    }

    /**
     * 执行耗时:6 ms,击败了92.55% 的Java用户
     * 内存消耗:38.4 MB,击败了78.43% 的Java用户
     */
    class Solution2 {
        private static final int MOD = 1_000_000_007;

        public int numRollsToTarget(int n, int k, int target) {
            if (target < n || target > n * k) return 0;
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;
            // 算每个骰子
            for (int i = 1; i <= n; i++) {
                // 在不算当前骰子的情况下，当前骰子能得到的分数范围
                for (int j = i; j <= target - (n - i); j++) {
                    // 当前骰子能掷出来的点数范围
                    for (int num = 1; num <= k && num <= j; num++) {
                        // 动态规划
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - num]) % MOD;
                    }
                }
            }
            return dp[n][target];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}