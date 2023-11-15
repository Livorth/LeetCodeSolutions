package daily.leetcode.editor.cn;

import java.util.*;

public class Question765 {
    public static void main(String[] args) {
        Solution solution = new Question765().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心，直接交换
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了24.45% 的Java用户
     */
    class Solution1 {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int res = 0;
            int[] cache = new int[n];
            for (int i = 0; i < n; i++) {
                cache[row[i]] = i;
            }
            for (int i = 0; i < n - 1; i += 2) {
                int a = row[i], b = a ^ 1;
                // b是否为a的另一半，如果不是则交换
                if (row[i + 1] != b) {
                    int src = i + 1, tar = cache[b];
                    // 更新位置信息
                    cache[row[tar]] = src;
                    cache[row[src]] = tar;
                    // 交换
                    int temp = row[src];
                    row[src] = row[tar];
                    row[tar] = temp;
                    res++;
                }
            }
            return res;
        }
    }


    /**
     * 并查集
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了21.24% 的Java用户
     */
    class Solution {
        // n最大为30，即最多为30队
        int[] p = new int[35];

        void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public int minSwapsCouples(int[] row) {
            int n = row.length, m = n / 2;
            // 初始化并查集
            for (int i = 0; i < m; i++) {
                p[i] = i;
            }
            // 计算并查集
            for (int i = 0; i < n; i += 2) {
                // 以一队情侣为单位，找环
                union(row[i] / 2, row[i + 1] / 2);
            }
            int count = 0;
            // 找到所有的环，同时包括所有不需要交换的情侣数量
            for (int i = 0; i < m; i++) {
                if (i == find(i)) {
                    count++;
                }
            }
            return m - count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}