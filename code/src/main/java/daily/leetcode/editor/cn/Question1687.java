package daily.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question1687 {
    public static void main(String[] args) {
        Solution solution = new Question1687().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int boxDelivering1(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
            int n = boxes.length;
            int[] p = new int[n + 1];
            int[] w = new int[n + 1];
            int[] neg = new int[n + 1];
            long[] W = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                p[i] = boxes[i - 1][0];
                w[i] = boxes[i - 1][1];
                if (i > 1) {
                    neg[i] = neg[i - 1] + (p[i - 1] != p[i] ? 1 : 0);
                }
                W[i] = W[i - 1] + w[i];
            }

            Deque<Integer> opt = new ArrayDeque<Integer>();
            opt.offerLast(0);
            int[] f = new int[n + 1];
            int[] g = new int[n + 1];

            for (int i = 1; i <= n; ++i) {
                while (i - opt.peekFirst() > maxBoxes || W[i] - W[opt.peekFirst()] > maxWeight) {
                    opt.pollFirst();
                }

                f[i] = g[opt.peekFirst()] + neg[i] + 2;

                if (i != n) {
                    g[i] = f[i] - neg[i + 1];
                    while (!opt.isEmpty() && g[i] <= g[opt.peekLast()]) {
                        opt.pollLast();
                    }
                    opt.offerLast(i);
                }
            }

            return f[n];
        }

        public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
            int n = boxes.length;
            int[] f = new int[n + 1];
            f[1] = 2;
            int diffSum = 2;
            int weightSum = boxes[0][1];
            int left = 0;
            for (int i = 1; i < n; ++i) {
                weightSum += boxes[i][1];
                // 不同码头，多走一次
                if (boxes[i][0] != boxes[i - 1][0]) diffSum++;
                // 重量超或个数超或左边界两个box在同一个码头时，左边界右移
                while (weightSum > maxWeight || i - left + 1 > maxBoxes || f[left + 1] == f[left]) {
                    weightSum -= boxes[left++][1];
                    if (boxes[left][0] != boxes[left - 1][0]) --diffSum;
                }
                // 贪心
                f[i + 1] = f[left] + diffSum;
            }
            return f[n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}