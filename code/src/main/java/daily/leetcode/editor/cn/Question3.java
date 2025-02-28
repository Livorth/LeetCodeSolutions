package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question3 {
    public static void main(String[] args) {
        Solution solution = new Question3().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n <= 1) return n;
            //  记录每个字符上一次出现的下标
            int[] record = new int[128];
            Arrays.fill(record, -1);
            int start = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                start = Math.max(start, record[s.charAt(i)] + 1);
                res = Math.max(res, i - start + 1);
                record[s.charAt(i)] = i;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

