package daily.leetcode.editor.cn;

public class Question808 {
    public static void main(String[] args) {
        Solution solution = new Question808().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private double[][] dp;

        public double soupServings(int n) {
            // 将25ml视为1分，降低数量级
            n = (int) Math.ceil((double) n / 25);
            // 题目中要求的精度是10^-5，在n==200的时候精度已经超过10^-5了
            if (n >= 200) return 1.0;
            dp = new double[n + 1][n + 1];
            return dfs(n, n);
        }

        public double dfs(int a, int b) {
            // a先完成分配的概率是0，同时完成的概率是1，合计0.5
            if (a <= 0 && b <= 0) {
                return 0.5;
            }
            // a先完成分配的概率是1，同时完成的概率是0，合计1
            else if (a <= 0) {
                return 1;
            }
            // a先完成分配的概率是0，同时完成的概率是0，合计0
            else if (b <= 0) {
                return 0;
            }
            // 记忆化搜索，如果没有则dfs计算
            if (dp[a][b] == 0) {
                // 每一种操作的概率都是0.25
                dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
            }
            return dp[a][b];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}