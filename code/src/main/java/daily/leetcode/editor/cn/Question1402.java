package daily.leetcode.editor.cn;

import java.util.*;

public class Question1402 {
    public static void main(String[] args) {
        Solution solution = new Question1402().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 第一眼排序，只留下所有正满意度的菜下来加起来不就好了吗
     * 第二眼看到第一个示例好像不太一样，因为选了-1后，5可以从*2变为*3
     * 后面只要简单找下规律就知道是否要选某个负满意度的菜了
     * 	执行耗时:1 ms,击败了100.00% 的Java用户
     * 	内存消耗:39.3 MB,击败了73.76% 的Java用户
     */
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            // 从最大到最小的满意度和，就是后缀和
            int preSum = 0;
            int res = 0;
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                preSum += satisfaction[i];
                if (preSum <= 0) break;
                // 每多选一道菜就加一次前缀和
                res += preSum;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}