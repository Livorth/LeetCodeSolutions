package daily.leetcode.editor.cn;

import java.util.*;

public class Question2697 {
    public static void main(String[] args) {
        Solution solution = new Question2697().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 从两头往中间遍历
     * 执行耗时:7 ms,击败了86.36% 的Java用户
     * 内存消耗:43.2 MB,击败了40.40% 的Java用户
     */
    class Solution {
        public String makeSmallestPalindrome(String S) {
            char[] s = S.toCharArray();
            for (int i = 0, n = s.length; i < n / 2; i++) {
                char x = s[i], y = s[n - 1 - i];
                if (x > y) s[i] = y;
                else s[n - 1 - i] = x;
            }
            return new String(s);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}