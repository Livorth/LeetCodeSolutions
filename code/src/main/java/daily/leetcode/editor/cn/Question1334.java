package daily.leetcode.editor.cn;

import java.util.*;

public class Question1334 {
    public static void main(String[] args) {
        Solution solution = new Question1334().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * floyd算法计算多源最短路
     * 执行耗时:7 ms,击败了98.05% 的Java用户
     * 内存消耗:41.9 MB,击败了61.80% 的Java用户
     */
    public class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            // 构建邻接矩阵
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = i == j ? 0 : 0x3f3f3f;
                }
            }
            for (int[] edge : edges) {
                int a = edge[0], b = edge[1];
                graph[a][b] = graph[b][a] = edge[2];
            }

            // floyd算法计算多源最短路
            int[][] floyd = graph;
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // i,j直连近还是靠k中转近
                        floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                    }
                }
            }
            // 统计每个点的邻居有多少个满足条件
            int res = 0;
            int minCount = n + 1;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && floyd[i][j] <= distanceThreshold) {
                        count++;
                    }
                }
                if (count <= minCount) {
                    minCount = count;
                    res = i;
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}