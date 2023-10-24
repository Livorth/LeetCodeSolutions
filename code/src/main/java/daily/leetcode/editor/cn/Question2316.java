package daily.leetcode.editor.cn;

import java.util.*;

public class Question2316 {
    public static void main(String[] args) {
        Solution solution = new Question2316().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 一眼并查集，重点求出每一个集中带点的个数
     * 每遍历得到一个集，则之前的每个点都能与当前集中的点形成新的对
     * 执行耗时:9 ms,击败了94.19% 的Java用户
     * 内存消耗:93.5 MB,击败了80.23% 的Java用户
     */
    class Solution1 {
        private int[] parent;
        private int[] size;

        private int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        private void union(int x, int y) {
            int px = find(x), py = find(y);
            // 将x挂到y下边，同时将y对应的size加到x中去
            if (px != py) {
                parent[px] = py;
                size[py] += size[px];
            }
        }

        public long countPairs(int n, int[][] edges) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int[] e : edges) {
                union(e[0], e[1]);
            }
            // count为已经遍历过集合中全部的点
            long res = 0L, count = 0L;
            for (int i = 0; i < n; i++) {
                if (find(i) == i) {
                    res += count * size[i];
                    count += size[i];
                }
            }
            return res;
        }
    }

    /**
     * 看其他人的写法后，获得新方法：染色dfs
     * 其实本质是一样的，每次dfs不过是找到一个并查集，然后标记记录后再dfs找后面的集合
     * 	执行耗时:50 ms,击败了23.84% 的Java用户
     * 	内存消耗:108.5 MB,击败了26.16% 的Java用户
     */
    class Solution {
        private List<Integer>[] graph;
        private boolean[] isVisit;

        public long countPairs(int n, int[][] edges) {
            graph = new List[n];
            isVisit = new boolean[n];

            // 构建临接表，方便后续dfs
            Arrays.setAll(graph, i -> new ArrayList<>());
            for (int[] e : edges) {
                int a = e[0], b = e[1];
                graph[a].add(b);
                graph[b].add(a);
            }

            long res = 0, size = 0;
            for (int i = 0; i < n; ++i) {
                int count = dfs(i);
                res += size * count;
                size += count;
            }
            return res;
        }

        // 获取从当前点出发能够存在多少点与之相连
        private int dfs(int i) {
            // 访问过的排除
            if (isVisit[i]) return 0;
            isVisit[i] = true;
            int count = 1;
            for (int j : graph[i]) {
                count += dfs(j);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}