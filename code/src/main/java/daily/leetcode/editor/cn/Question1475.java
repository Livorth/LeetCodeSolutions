package daily.leetcode.editor.cn;

import java.util.*;

public class Question1475 {
    public static void main(String[] args) {
        Solution solution = new Question1475().new Solution();
        int[] prices = {8,4,6,2,3};
        solution.finalPrices(prices);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 简单模拟
        public int[] finalPrices1(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int curPrices = prices[i];
                //找到第一个小于等于的元素
                for (int j = i + 1; j < n; j++) {
                    if (prices[j] <= prices[i]) {
                        curPrices -= prices[j];
                        break;
                    }
                }
                ans[i] = curPrices;
            }
            return ans;
        }

        // 单调栈
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            int[] stack = new int[n];
            int top = -1;
            for (int i = 0; i < n; i++) {
                // 对栈顶元素进行一个判断，看是否能出栈计算结果
                while(top != -1 && prices[stack[top]] >= prices[i]){
                    int index = stack[top--];
                    ans[index] = prices[index] - prices[i];
                }
                // 每个元素都拿去入栈
                stack[++top] = i;
                ans[i] = prices[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}