package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question826 {
    public static void main(String[] args) {
        Solution solution = new Question826().new Solution();
        solution.maxProfitAssignment(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7}
        );

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心+双指针
     * 执行耗时:16 ms,击败了82.49% 的Java用户
     * 内存消耗:44.4 MB,击败了82.03% 的Java用户
     */
    class Solution1 {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
            int n = difficulty.length;
            int[][] works = new int[n][2];
            for (int i = 0; i < n; i++) {
                works[i][0] = difficulty[i];
                works[i][1] = profit[i];
            }
            // 从简单到难
            Arrays.sort(works, (a, b) -> a[0] - b[0]);
            // 从实习工到熟练工
            Arrays.sort(workers);
            int res = 0;
            int maxProfit = 0;
            int i = 0;
            for (int worker : workers) {
                // 找到直到当前工作难度中收益最大的工作
                while (i < n && works[i][0] <= worker) {
                    maxProfit = Math.max(maxProfit, works[i++][1]);
                }
                res += maxProfit;
            }
            return res;
        }
    }

    /**
     * 贪心+二分查找（适合工人很多的情况）
     * 执行耗时:17 ms,击败了71.89% 的Java用户
     * 内存消耗:44.5 MB,击败了67.28% 的Java用户
     */
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
            int n = difficulty.length;
            int[][] works = new int[n][2];
            for (int i = 0; i < n; i++) {
                works[i][0] = difficulty[i];
                works[i][1] = profit[i];
            }
            // 从简单到难
            Arrays.sort(works, (a, b) -> a[0] - b[0]);
            int maxProfit = 0;
            for (int[] work : works) {
                if (maxProfit > work[1]) {
                    work[1] = maxProfit;
                } else {
                    maxProfit = work[1];
                }
            }

            int res = 0;
            for (int worker : workers) {
                int p = lowerBound(works, worker);
                if (p != -1) res += works[p][1];
            }
            return res;
        }

        private int lowerBound(int[][] works, int target) {
            int left = 0, right = works.length;
            while (left < right) {
                int mid = (left + right) >>> 1;
                // mid的难度比目标值更大，则落在左侧
                if (works[mid][0] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}