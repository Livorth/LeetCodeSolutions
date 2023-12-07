package daily.leetcode.editor.cn;

import java.util.*;

public class Question1466 {
    public static void main(String[] args) {
        Solution solution = new Question1466().new Solution();
        solution.minReorder(6, new int[][]{
                {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}
        });

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dfs，找出每个节点除了上层节点外有多少个下级节点
     * 执行耗时:50 ms,击败了28.76% 的Java用户
     * 内存消耗:66.2 MB,击败了69.44% 的Java用户
     */
    class Solution {
        List<Integer>[] in;
        List<Integer>[] out;

        public int minReorder(int n, int[][] connections) {
            out = new List[n];
            in = new List[n];
            for (int i = 0; i < n; i++) {
                out[i] = new ArrayList<>();
                in[i] = new ArrayList<>();
            }
            for (int[] c : connections) {
                out[c[0]].add(c[1]);
                in[c[1]].add(c[0]);
            }
            return dfs(0, -1);
        }

        private int dfs(int node, int parent) {
            int res = 0;
            for (int i : out[node]) {
                if (i == parent) continue;
                res += 1 + dfs(i, node);
            }
            for (int i : in[node]) {
                if (i == parent) continue;
                res += dfs(i, node);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}