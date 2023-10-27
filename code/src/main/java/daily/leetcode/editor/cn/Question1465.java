package daily.leetcode.editor.cn;

import java.util.*;

public class Question1465 {
    public static void main(String[] args) {
        Solution solution = new Question1465().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:14 ms,击败了100.00% 的Java用户
     * 内存消耗:52.9 MB,击败了28.89% 的Java用户
     */
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int maxH = getMaxGap(horizontalCuts, h);
            int maxV = getMaxGap(verticalCuts, w);
            return (int) (((long) maxH * maxV) % 1_000_000_007);
        }

        private int getMaxGap(int[] counts, int h) {
            Arrays.sort(counts);
            // 首尾部分的边界值
            int max = Math.max(counts[0], h - counts[counts.length - 1]);
            // 遍历每一个切割线，求出最大的间隙
            for (int i = 1; i < counts.length; i++) {
                max = Math.max(max, counts[i] - counts[i - 1]);
            }
            return max;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}