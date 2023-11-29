package daily.leetcode.editor.cn;

import java.util.*;

public class Question2258 {
    public static void main(String[] args) {
        Solution solution = new Question2258().new Solution();
//        solution.maximumMinutes(new int[][]{
//                {0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 1, 0}, {0, 2, 0, 0, 1, 2, 0}, {0, 0, 2, 2, 2, 0, 2}, {0, 0, 0, 0, 0, 0, 0}
//        });

        solution.maximumMinutes(new int[][]{
                { 0, 0, 0}, {2, 2, 0}, {1, 2, 0}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 两遍bfs
     * 第一遍bfs统计出每个地点起火的时间
     * 第二遍bfs统计出人到每个地点能等待的最长时间
     * 执行耗时:11 ms,击败了95.00% 的Java用户
     * 内存消耗:44.3 MB,击败了53.41% 的Java用户
     */
    class Solution {
        private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int maximumMinutes(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            // 1. bfs求出每个点起火的最早时间
            // 1.1. 初始化fireMap数组，用于存储每个点起火的最短时间
            int[][] fireMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(fireMap[i], 0x3f3f3f3f);
            }
            // 1.2. bfs计算每个点的起火时间
            Deque<int[]> que = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        que.add(new int[]{i, j});
                        fireMap[i][j] = 0;
                    }
                }
            }
            while (!que.isEmpty()) {
                int[] nowFire = que.poll();
                int value = fireMap[nowFire[0]][nowFire[1]];
                // 枚举当前点的4个方向
                for (int[] d : DIRS) {
                    int x = nowFire[0] + d[0], y = nowFire[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < m
                            && grid[x][y] == 0 && fireMap[x][y] > value + 1) {
                        fireMap[x][y] = value + 1;
                        que.add(new int[]{x, y});
                    }
                }
            }
            // 注意点：如果人到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。所以我们需要把终点值加一。
            fireMap[n - 1][m - 1]++;
            // 2. 计算起点到每个点可以停留的最长分钟数
            // 2.1. 初始化manMap数组，用于存储每个点最长等待时间
            int[][] manMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(manMap[i], -1);
            }
            manMap[0][0] = fireMap[0][0] - 1;
            // 2.1. bfs计算每个点人最多的等待时间
            // 第三个参数用于存储人到那个点的最短时间，用于计算出最长的等待时间
            que.add(new int[]{0, 0, 0});
            while (!que.isEmpty()) {
                int[] nowMan = que.poll();
                int value = manMap[nowMan[0]][nowMan[1]];
                for (int[] d : DIRS) {
                    int x = nowMan[0] + d[0], y = nowMan[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < m
                            && grid[x][y] != 2 && fireMap[x][y] > nowMan[2] + 1) {
                        // 火到当前位置的时间 - 人到当前位置的时间 - 1（减1是因为你得在火到之前离开这个位置）
                        int min = Math.min(value, fireMap[x][y] - (nowMan[2] + 1) - 1);
                        // 更新当前位置的最小时间，并继续bfs
                        if (manMap[x][y] < min) {
                            manMap[x][y] = min;
                            que.add(new int[]{x, y, nowMan[2] + 1});
                        }
                    }
                }
            }
            // 火到不了则1e9
            if (manMap[n - 1][m - 1] >= 0x3f3f3f) return (int) 1e9;
            return manMap[n - 1][m - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}