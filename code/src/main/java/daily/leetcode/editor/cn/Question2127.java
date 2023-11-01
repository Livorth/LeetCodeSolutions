package daily.leetcode.editor.cn;

import java.util.*;

public class Question2127 {
    public static void main(String[] args) {
        Solution solution = new Question2127().new Solution();
        solution.maximumInvitations(new int[]{2, 2, 1, 2});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int maximumInvitations(int[] favorite) {
            int n = favorite.length;
            int[] deg = new int[n];
            for (int f : favorite) {
                deg[f]++; // 统计基环树每个节点的入度
            }

            int[] maxDepth = new int[n];
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) { // 拓扑排序，剪掉图上所有树枝
                int x = q.poll();
                int y = favorite[x]; // x 只有一条出边
                maxDepth[y] = maxDepth[x] + 1;
                if (--deg[y] == 0) {
                    q.add(y);
                }
            }

            int maxRingSize = 0, sumChainSize = 0;
            for (int i = 0; i < n; i++) {
                if (deg[i] == 0) continue;

                // 遍历基环上的点
                deg[i] = 0; // 将基环上的点的入度标记为 0，避免重复访问
                int ringSize = 1; // 基环长度
                for (int x = favorite[i]; x != i; x = favorite[x]) {
                    deg[x] = 0; // 将基环上的点的入度标记为 0，避免重复访问
                    ringSize++;
                }

                if (ringSize == 2) { // 基环长度为 2
                    sumChainSize += maxDepth[i] + maxDepth[favorite[i]] + 2; // 累加两条最长链的长度
                } else {
                    maxRingSize = Math.max(maxRingSize, ringSize); // 取所有基环长度的最大值
                }
            }
            return Math.max(maxRingSize, sumChainSize);
        }
    }

    /**
     * 执行耗时:7 ms,击败了100.00% 的Java用户
     * 内存消耗:58.3 MB,击败了55.86% 的Java用户
     */
    class Solution {
        public int maximumInvitations(int[] favorite) {
            int length = favorite.length;
            // 1. 拓扑排序，只留下基环
            // 1.1 计算入度
            int[] rdo = new int[length];
            for (int i : favorite) {
                rdo[i]++;
            }

            // 1.2 拓扑排序，同时计算到当前节点时，树枝的长度
            int[] queue = new int[length];
            int l = 0, r = 0;
            for (int i = 0; i < length; i++) {
                if (rdo[i] == 0) queue[r++] = i;
            }

            int[] depth = new int[length];
            while (l < r) {
                int cur = queue[l++];
                int next = favorite[cur];
                depth[next] = depth[cur] + 1;
                // in的入度会减少1
                rdo[next]--;
                // 没有入度了就也加入队列等待被去掉
                if (rdo[next] == 0) queue[r++] = next;
            }

            // 2. 遍历每一个环
            int res = 0;
            int sumTwoRing = 0;
            for (int i = 0; i < length; i++) {
                if (rdo[i] == 0) continue;
                // 计算环中节点数
                int size = 1;
                int in = favorite[i];
                while (in != i) {
                    // 遍历过的置为0，防止循环
                    rdo[in] = 0;
                    size++;
                    in = favorite[in];
                }
                // 2.1 环中的节点只有两个，可以接两边的树枝形成一条线，两边还可以继续加其他线
                if (size == 2) {
                    sumTwoRing += 2 + depth[i] + depth[favorite[i]];
                }
                // 2.2 环中的节点大于了两个，只能当前环围一桌
                else {
                    res = Math.max(res, size);
                }
            }
            return Math.max(res, sumTwoRing);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}