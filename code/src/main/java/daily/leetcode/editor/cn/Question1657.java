package daily.leetcode.editor.cn;

import java.util.*;

public class Question1657 {
    public static void main(String[] args) {
        Solution solution = new Question1657().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:9 ms,击败了97.20% 的Java用户
     * 内存消耗:43.7 MB,击败了13.02% 的Java用户
     */
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            int a = 0;
            int b = 0;
            int[] x = new int[26];
            int[] y = new int[26];

            for (byte aByte : word1.getBytes()) {
                int c = aByte - 'a';
                a |= 1 << c;
                x[c]++;
            }
            for (byte aByte : word2.getBytes()) {
                int c = aByte - 'a';
                b |= 1 << c;
                y[c]++;
            }
            if ((a ^ b) != 0) return false;

            Arrays.sort(x);
            Arrays.sort(y);
            for (int i = 0; i < 26; i++) {
                if (x[i] != y[i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}