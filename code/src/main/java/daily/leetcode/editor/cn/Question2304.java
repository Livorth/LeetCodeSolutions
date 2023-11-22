package daily.leetcode.editor.cn;

import java.util.*;

public class Question2304 {
    public static void main(String[] args) {
        Solution solution = new Question2304().new Solution();
        solution.minPathCost(new int[][]{
                {5, 3}, {4, 0}, {2, 1}
        }, new int[][]{
                {9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}
        });

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 记忆化搜索
     * 执行耗时:9 ms,击败了21.05% 的Java用户
     * 内存消耗:65.1 MB,击败了5.26% 的Java用户
     */
    class Solution {
        int[][] grid;
        int[][] move;
        int[][] cost;

        public int minPathCost(int[][] grid, int[][] moveCost) {
            this.grid = grid;
            this.move = moveCost;
            int m = grid.length;
            int n = grid[0].length;
            this.cost = new int[m][n];

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.min(res, dfs(0, i));
            }
            return res;
        }

        private int dfs(int depth, int t) {
            int value = grid[depth][t];
            if (depth == grid.length - 1) return value;
            if (cost[depth][t] != 0) return cost[depth][t];

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < grid[depth].length; i++) {
                res = Math.min(res, dfs(depth + 1, i) + move[value][i]);
            }
            cost[depth][t] = res + value;
            return cost[depth][t];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}