package daily.leetcode.editor.cn;

import java.util.*;

public class Question902 {
    public static void main(String[] args) {
        Solution solution = new Question902().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            // 将n转换成char数组
            char[] s = String.valueOf(n).toCharArray();
            int result = 0, ncl = s.length, dl = digits.length;
            // 先不考虑最高位，只计算出在没有最高位的情况下的数量
            for (int i = 1; i < ncl; i++) result += Math.pow(dl, i);
            // 从首位开始往后遍历
            for (int i = 0; i < ncl; i++) {
                boolean compareNext = false;
                for (String digit : digits) {
                    char dc = digit.charAt(0);
                    // 如果当前位大于当前数，说明当前数可以作为首位，可以将后续的情况添加进结果
                    if (dc < s[i]) result += Math.pow(dl, ncl - i - 1);
                    else {
                        // 当前位等于某一个数时则需要继续往下一位遍历
                        if (dc == s[i]) compareNext = true; break;
                    }
                }
                // 如果没发送往后进位的情况，则返回结果
                if (!compareNext) return result;
            }
            // 到这个地方了则说明直到最后一位依旧还是可以往后进位的，但是由于最后一位无法往后对比了，所以结果加一，也就是单个当前数
            return ++result;
        }
    }

    class Solution {
        private String[] digits;
        private char s[];
        private int dp[];

        public int atMostNGivenDigitSet(String[] digits, int n) {
            this.digits = digits;
            s = Integer.toString(n).toCharArray();
            dp = new int[s.length];
            Arrays.fill(dp, -1); // dp[i] = -1 表示 i 这个状态还没被计算出来
            return f(0, true, false);
        }

        private int f(int i, boolean isLimit, boolean isNum) {
            if (i == s.length) return isNum ? 1 : 0; // 如果填了数字，则为 1 种合法方案
            if (!isLimit && isNum && dp[i] >= 0) return dp[i]; // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
            int res = 0;
            if (!isNum) // 前面不填数字，那么可以跳过当前数位，也不填数字
                // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
                // isNum 仍然为 false，因为没有填任何数字
                res = f(i + 1, false, false);
            char up = isLimit ? s[i] : '9'; // 根据是否受到约束，决定可以填的数字的上限
            // 注意：对于一般的题目而言，如果此时 isNum 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
            for (String d : digits) { // 枚举要填入的数字 d
                if (d.charAt(0) > up) break; // d 超过上限，由于 digits 是有序的，后面的 d 都会超过上限，故退出循环
                // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
                // isNum 为 true，因为填了数字
                res += f(i + 1, isLimit && d.charAt(0) == up, true);
            }
            if (!isLimit && isNum) dp[i] = res; // 在不受到任何约束的情况下，记录结果
            return res;
        }
    }

    class Solution2 {
        private int[] a = new int[12];
        private int[][] dp = new int[12][2];
        private Set<Integer> s = new HashSet<>();

        public int atMostNGivenDigitSet(String[] digits, int n) {
            for (int[] e : dp) {
                Arrays.fill(e, -1);
            }
            for (String d : digits) {
                s.add(Integer.parseInt(d));
            }
            int len = 0;
            while (n > 0) {
                a[++len] = n % 10;
                n /= 10;
            }
            return dfs(len, 1, true);
        }

        private int dfs(int pos, int lead, boolean limit) {
            if (pos <= 0) {
                return lead ^ 1;
            }
            if (!limit && lead != 1 && dp[pos][lead] != -1) {
                return dp[pos][lead];
            }
            int ans = 0;
            int up = limit ? a[pos] : 9;
            for (int i = 0; i <= up; ++i) {
                if (i == 0 && lead == 1) {
                    ans += dfs(pos - 1, lead, limit && i == up);
                } else if (s.contains(i)) {
                    ans += dfs(pos - 1, 0, limit && i == up);
                }
            }
            if (!limit && lead == 0) {
                dp[pos][lead] = ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}