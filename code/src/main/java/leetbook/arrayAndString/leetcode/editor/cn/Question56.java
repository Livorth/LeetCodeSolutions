package leetbook.arrayAndString.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question56 {
    public static void main(String[] args) {
        Solution solution = new Question56().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int len = intervals.length;
            List<int[]> ans = new LinkedList<int[]>();
            for (int i = 0; i < len; i++) {
                int min = intervals[i][0];
                int max = intervals[i][1];
                // 将当前范围的右边界外扩
                while (i < len && max >= intervals[i][0]) {
                    max = Math.max(intervals[i++][1], max);
                }
                i--;
                ans.add(new int[]{min, max});
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}