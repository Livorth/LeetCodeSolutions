package daily.leetcode.editor.cn;

import java.util.*;

public class Question2652 {
    public static void main(String[] args) {
        Solution solution = new Question2652().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfMultiples(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    res += i;
                    continue;
                }
                if (i % 5 == 0) {
                    res += i;
                    continue;
                }
                if (i % 7 == 0) {
                    res += i;
                    continue;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}