package daily.leetcode.editor.cn;

import java.util.*;

public class Question2920 {
    public static void main(String[] args) {
        Solution solution = new Question2920().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 记忆化搜索
     * 执行耗时:131 ms,击败了29.49% 的Java用户
     * 内存消耗:111.9 MB,击败了50.42% 的Java用户
     */
    class Solution {
        public int maximumPoints(int[][] edges, int[] coins, int k) {
            // 建临接表
            List<Integer>[] graph = new ArrayList[coins.length];
            Arrays.setAll(graph, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                graph[x].add(y);
                graph[y].add(x);
            }
            // 记忆化，最大10^4,除以14次2就到0了
            // memo中i为节点标识，j为当前被除以了几个2了
            int[][] memo = new int[coins.length][14];
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
            // dfs
            return dfs(0, 0, -1, graph, memo, coins, k);
        }

        /**
         * @param i  节点编号
         * @param j  选择过多少次方案二，后续节点需要除以多少次2
         * @param pa 父节点，防止往回走了
         * @return
         */
        private int dfs(int i, int j, int pa, List<Integer>[] graph, int[][] memo, int[] coins, int k) {
            // 在题目的数据范围内，后续所有的节点移超过14位都是0了
            if (j >= 14) return 0;
            if (memo[i][j] != -1) return memo[i][j];
            // 两种方案都需要计算
            int type1 = (coins[i] >> j) - k;
            int type2 = coins[i] >> (j + 1);
            for (Integer next : graph[i]) {
                if (next == pa) continue;
                type1 += dfs(next, j, i, graph, memo, coins, k);
                type2 += dfs(next, j + 1, i, graph, memo, coins, k);
            }
            // 记忆化
            memo[i][j] = Math.max(type1, type2);
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}