package daily.leetcode.editor.cn;

import java.util.*;

public class Question1094 {
    public static void main(String[] args) {
        Solution solution = new Question1094().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:1 ms,击败了98.48% 的Java用户
     * 内存消耗:42.2 MB,击败了48.30% 的Java用户
     */
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            // min与max缩小二次遍历的时间，count记录在当前位置车上会有多少个乘客
            int min = 1000, max = 0, count = 0;
            int[] lens = new int[1001];
            for (int[] trip : trips) {
                lens[trip[1]] += trip[0];
                lens[trip[2]] -= trip[0];
                min = Math.min(min, trip[1]);
                max = Math.max(max, trip[2]);
            }
            for (int i = min; i <= max; i++) {
                count += lens[i];
                if (count > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}