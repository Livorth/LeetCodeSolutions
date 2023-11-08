package daily.leetcode.editor.cn;

import java.util.*;

public class Question2609 {
    public static void main(String[] args) {
        Solution solution = new Question2609().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了80.81% 的Java用户
     */
    class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int res = 0;
            int index = 0;
            char[] chars = s.toCharArray();

            while (index < chars.length) {
                int zCount = 0;
                int oCount = 0;
                while (index < s.length() && chars[index] == '0') {
                    zCount++;
                    index++;
                }
                while (index < s.length() && chars[index] == '1') {
                    oCount++;
                    index++;
                }
                res = Math.max(res, Math.min(zCount, oCount) * 2);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}