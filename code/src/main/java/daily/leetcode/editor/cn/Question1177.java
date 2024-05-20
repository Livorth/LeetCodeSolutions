package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Question1177 {
    public static void main(String[] args) {
        Solution solution = new Question1177().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 前缀异或和，sum[i]中的每个二进制位都是存储的对应字母出现的奇偶次数
     * 执行耗时:9 ms,击败了54.47% 的Java用户
     * 内存消耗:94.6 MB,击败了64.23% 的Java用户
     */
    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int n = s.length();
            // 异或前缀和，26个字母，int能存下
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int bit = 1 << (s.charAt(i) - 'a');
                sum[i + 1] = sum[i] ^ bit;
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] q : queries) {
                int l = q[0], r = q[1], k = q[2];
                int xor = sum[r + 1] ^ sum[l];
                int cnt = 0;
                while (xor != 0) {
                    cnt += xor & 1;
                    xor >>= 1;
                }
                ans.add(cnt / 2 <= k);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}