package daily.leetcode.editor.cn;

public class Question2156 {
    public static void main(String[] args) {
        Solution solution = new Question2156().new Solution();
        String s = solution.subStrHash("leetcode", 7, 20, 2, 0);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 每次都遍历遍窗口中的所有字符，时间复杂度O(kn)
     * 执行耗时:2688 ms,击败了5.80% 的Java用户
     * 内存消耗:44.2 MB,击败了17.39% 的Java用户
     */
    class Solution1 {
        public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
            char[] chars = s.toCharArray();
            for (int i = 0; i <= chars.length - k; i++) {
                int hash = getHash(chars, i, k, power, modulo);
                if (hash == hashValue) return s.substring(i, i + k);
            }
            return s;
        }

        private int getHash(char[] chars, int start, int k, int p, int mod) {
            long pp = 1;
            long hash = 0;
            for (int i = start; i < start + k; i++) {
                hash += ((chars[i] - 'a' + 1) % mod * pp) % mod;
                pp = (p * pp) % mod;
            }
            return (int) (hash % mod);
        }
    }

    /**
     * 利用公式计算，直接求解，时间复杂度O(n)
     * 执行耗时:10 ms,击败了81.16% 的Java用户
     * 内存消耗:44.2 MB,击败了13.04% 的Java用户
     */
    class Solution {
        public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
            char[] chars = s.toCharArray();
            long pp = 1;
            long hash = 0;
            int res = s.length();

            // 初始化滑动窗口中的hash
            for (int i = 0; i < k; i++) {
                if (i < k - 1) {
                    pp = (pp * power) % modulo;
                }
                hash = (hash * power + chars[s.length() - 1 - i] - 'a' + 1) % modulo;
            }
            if (hashValue == hash) {
                res -= k;
            }
            // 从后往前遍历,窗口前移
            for (int i = s.length() - k - 1; i >= 0; i--) {
                hash = ((hash + (modulo - pp) * (chars[i + k] - 'a' + 1)) % modulo * power + chars[i] - 'a' + 1) % modulo;
                if (hash == hashValue) {
                    res = i;
                }
            }
            return s.substring(res, res + k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}