package daily.leetcode.editor.cn;

import java.util.*;

public class Question2698 {
    public static void main(String[] args) {
        Solution solution = new Question2698().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:5 ms,击败了67.72% 的Java用户
     * 内存消耗:38.3 MB,击败了83.86% 的Java用户
     */
    class Solution {
        public int punishmentNumber(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (dfs(i * i, i)) {
                    res += i * i;
                }
            }
            return res;
        }

        // 判断把num分割之后加起来能不能组成target
        boolean dfs(int num, int target) {
            if (num == target) return true;
            int step = 10;
            // 从后往前，一次切一位
            while (num >= target && target >= num % step) {
                if (dfs(num / step, target - (num % step))) {
                    return true;
                }
                step *= 10;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}