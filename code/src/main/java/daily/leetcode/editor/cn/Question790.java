package daily.leetcode.editor.cn;

public class Question790 {
    public static void main(String[] args) {
        Solution solution = new Question790().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        public int numTilings(int n) {
            // f(n) = 2 * f(n-1) + f(n-3) (n>3)
            if (n == 1) return 1;
            // 初始化
            long a = 1, b = 1, c = 2;
            for (int i = 3; i <= n; ++i) {
                long tmp = (c * 2 + a) % MOD;
                a = b;
                b = c;
                c = tmp;
            }
            return (int) c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}