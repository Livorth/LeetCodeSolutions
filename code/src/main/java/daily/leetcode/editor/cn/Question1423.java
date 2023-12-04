package daily.leetcode.editor.cn;

import java.util.*;

public class Question1423 {
    public static void main(String[] args) {
        Solution solution = new Question1423().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int s = 0;
            for (int i = 0; i < k; i++) {
                s += cardPoints[i];
            }
            int ans = s;
            for (int i = 1; i <= k; i++) {
                s += cardPoints[cardPoints.length - i] - cardPoints[k - i];
                ans = Math.max(ans, s);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}