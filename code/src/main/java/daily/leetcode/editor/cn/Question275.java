package daily.leetcode.editor.cn;

import java.util.*;

public class Question275 {
    public static void main(String[] args) {
        Solution solution = new Question275().new Solution();
        System.out.println(solution.hIndex(new int[]{1, 2, 100}));
        System.out.println(solution.hIndex(new int[]{0}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:49.3 MB,击败了70.93% 的Java用户
     */
    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (citations[mid] < len - mid) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return len - right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}