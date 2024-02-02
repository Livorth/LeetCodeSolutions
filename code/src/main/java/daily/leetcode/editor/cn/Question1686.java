package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question1686 {
    public static void main(String[] args) {
        Solution solution = new Question1686().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 博弈，贪心，需要使自己受益最大的同时使对方的受益最小
     * 执行耗时:85 ms,击败了52.46% 的Java用户
     * 内存消耗:58.9 MB,击败了26.23% 的Java用户
     */
    class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int n = aliceValues.length;
            Integer[] index = new Integer[n];
            for (int i = 0; i < n; i++) index[i] = i;
            Arrays.sort(index, (i, j) -> aliceValues[j] + bobValues[j] - aliceValues[i] - bobValues[i]);
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) a += aliceValues[index[i]];
                else b += bobValues[index[i]];
            }
            return Integer.compare(a - b, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}