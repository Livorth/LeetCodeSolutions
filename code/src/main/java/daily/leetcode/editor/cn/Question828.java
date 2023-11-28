package daily.leetcode.editor.cn;

import java.util.*;

public class Question828 {
    public static void main(String[] args) {
        Solution solution = new Question828().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动态规划，维护以当前位置结尾的子串的countUniqueChars值和
     * 执行耗时:6 ms,击败了89.69% 的Java用户
     * 内存消耗:43.3 MB,击败了69.96% 的Java用户
     */
    class Solution {
        public int uniqueLetterString(String s) {
            // 记录字母上两次出现的位置，默认为负一方便后续计算
            int[][] index = new int[26][2];
            for (int i = 0; i < 26; i++) {
                index[i][0] = index[i][1] = -1;
            }
            int res = 0;
            // count记录以当前位置结尾的子串的countUniqueChars值和
            int sum = 0;
            byte[] bytes = s.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                int c = bytes[i] - 'A';
                // 当前位置到上一次的位置里的所有子串的count均+1
                sum += i - index[c][1];
                // 上次位置到上上次位置的所有子串的count均-1
                sum -= index[c][1] - index[c][0];
                res += sum;
                index[c][0] = index[c][1];
                index[c][1] = i;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}