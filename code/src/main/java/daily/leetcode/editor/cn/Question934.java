package daily.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question934 {
    public static void main(String[] args) {
        Solution solution = new Question934().new Solution();
        solution.shortestBridge(new int[][]{{0, 1}, {1, 0}});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int[][] m;
        int M, N;


        public int shortestBridge(int[][] m) {
            this.m = m;
            this.M = m.length;
            this.N = m[0].length;
            int all = M * N;

            // 将岛1的坐标放入队列
            int[] firstIndex = new int[all];
            // 队列结束的位置
            int land1Size = 0;


            //找出岛1所有的点，将他们都加入队列，并标记它们为-1
            for (int row = 0; row < M; row++) {
                for (int col = 0; col < N; col++) {
                    if (m[row][col] == 1) {
                        //岛1的大小
                        land1Size = dfs(row, col, firstIndex, 0);
                        break;
                    }
                }
                if (land1Size > 0) break;
            }

            // BFS扩充岛1，直到遇到岛2
            int[] nextIndex = new int[all];
            int length = 0;
            while (true) {
                // 只遍历一层
                int size = bfs(firstIndex, land1Size, nextIndex);
                if (size == -1) {
                    return length;
                }
                length++;
                // 模拟队列
                firstIndex = nextIndex;
                nextIndex = new int[all];
                land1Size = size;
            }
        }

        /**
         * 通过dfs将岛1全部放入队列中，并将每一个点置为 -1
         */
        public int dfs(int row, int col, int[] landIndex, int size) {
            // 遇到边界，返回
            if (!isLegal(row, col) || m[row][col] != 1) {
                return size;
            }
            m[row][col] = -1;
            // 将2维坐标转换为1维
            int index = row * M + col;
            // 加入队列
            landIndex[size++] = index;

            // 往4个方向进行dfs
            for (int[] g : grid) {
                size = dfs(row + g[0], col + g[1], landIndex, size);
            }
            return size;
        }

        public int bfs(int[] curIndex, int curSize, int[] nextIndex) {
            int nextSize = 0;
            for (int i = 0; i < curSize; i++) {
                for (int[] g : grid) {
                    int row = curIndex[i] / N + g[0];
                    int col = curIndex[i] % N + g[1];
                    if (isLegal(row, col) && m[row][col] == 0) {
                        m[row][col] = -1;
                        nextIndex[nextSize++] = row * N + col;
                    } else if (isLegal(row, col) && m[row][col] == 1) {
                        return -1;
                    }
                }
            }
            return nextSize;
        }

        public boolean isLegal(int row, int column) {
            return row >= 0 && row < M && column >= 0 && column < N;
        }
    }

    class Solution1 {
        int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
        Deque<int[]> edges; // 用户存储边缘格子

        public int shortestBridge(int[][] grid) {
            int result = 0;
            boolean findIsland = false; // 只要找到2个岛屿中其中的1个岛屿，就将其设置为true，并结束步骤1中的两层for循环
            edges = new ArrayDeque();
            this.grid = grid;
            /** 步骤1：为其中一个岛屿打标记（val=2），并保存”边界格子“到edges中 */
            for (int i = 0; !findIsland && i < grid.length; i++)
                for (int j = 0; !findIsland && j < grid[0].length; j++)
                    if (findIsland = (grid[i][j] == 1)) markIsland(i, j);

            /** 步骤2：利用边界edges，一层一层扩展岛屿（val=2），直到遇到另一个岛屿（val=1）*/
            while (!edges.isEmpty()) {
                result++; // 扩展层数
                int num = edges.size();
                for (int i = 0; i < num; i++) {
                    int[] edge = edges.removeFirst();
                    for (int[] c : coordinates) { // 向edge的四个方向查看格子编号，并扩展岛屿边界
                        int nex = edge[0] + c[0], ney = edge[1] + c[1];
                        if (isLegal(nex, ney) && grid[nex][ney] == 0) {
                            edges.addLast(new int[]{nex, ney}); // 添加新的边界
                            grid[nex][ney] = 2;
                        } else if (isLegal(nex, ney) && grid[nex][ney] == 1) return result; // 与另一个岛屿相遇，则直接返回result
                    }
                }
            }
            return result;
        }

        public void markIsland(int row, int column) {
            if (!isLegal(row, column) || grid[row][column] == 2) return;
            if (grid[row][column] == 0) {
                grid[row][column] = 2; // 将边界向外扩展1层岛屿（val=2)
                edges.addLast(new int[]{row, column});
                return;
            }
            grid[row][column] = 2; // 为岛屿打标记（val=2）
            for (int[] c : coordinates) {
                markIsland(row + c[0], column + c[1]); // 深度遍历某个格子的四个方向
            }
        }

        public boolean isLegal(int row, int column) {
            return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
