package daily.leetcode.editor.cn;

import java.util.*;

public class Question2213 {
    public static void main(String[] args) {
        Solution solution = new Question2213().new Solution();
        solution.longestRepeating("babacc", "bcb", new int[]{1, 3, 3});
        solution.longestRepeating("abyzz", "aa", new int[]{2, 1});
        solution.longestRepeating("mm", "bfviuwsr", new int[]{0, 0, 1, 0, 0, 1, 1, 0});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int begin = 0;
        private int end = 0;
        private int maxLength = Integer.MIN_VALUE;

        public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
            int[] res = new int[queryIndices.length];
            // 1. 首先求出当前s中最长子串的首位位置
            char[] chars = s.toCharArray();

            getMinChildString(chars);
            // 2. 模拟每一次操作
            char[] queryChars = queryCharacters.toCharArray();
            for (int i = 0; i < queryIndices.length; i++) {
                int index = queryIndices[i];
                chars[index] = queryChars[i];
                // 如果影响到现有最长区间
                if (index <= end && index >= begin) {
                    getMinChildString(chars);
                }
                // 如果没有影响到则判断是否需要更新当前最新
                else {
                    int a = index;
                    int b = index;
                    while (a - 1 >= 0 && chars[a] == chars[a - 1]) {
                        a--;
                    }
                    while (b + 1 < s.length() && chars[b] == chars[b + 1]) {
                        b++;
                    }
                    if ((b - a) > (end - begin)) {
                        end = b;
                        begin = a;
                    }
                }
                res[i] = end - begin + 1;
            }
            return res;
        }

        private void getMinChildString(char[] chars) {
            begin = 0;
            end = 0;
            for (int i = 0, j = 1; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    i = j;
                }
                if ((j - i) > (end - begin)) {
                    end = j;
                    begin = i;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}