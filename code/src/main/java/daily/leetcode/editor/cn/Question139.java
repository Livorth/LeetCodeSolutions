package daily.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Question139 {
    public static void main(String[] args) {
        Solution solution = new Question139().new Solution();
        solution.wordBreak("leetcode", Arrays.asList("leet", "code"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动态规划，遍历字符串，遍历字典，判断以word结尾，同时满足上一位置的dp为true
     * 执行耗时:6 ms,击败了76.24% 的Java用户
     * 内存消耗:43.3 MB,击败了70.61% 的Java用户
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (String word : wordDict) {
                    if (word.length() > i) continue;
                    // 以word结尾同时满足上一位置的dp为true
                    if (s.substring(0, i).endsWith(word) && dp[i - word.length()]) {
                        dp[i] = true;
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}