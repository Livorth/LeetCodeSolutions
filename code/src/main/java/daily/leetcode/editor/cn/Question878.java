package daily.leetcode.editor.cn;

public class Question878 {
    public static void main(String[] args) {
        Solution solution = new Question878().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        public int nthMagicalNumber(int n, int a, int b) {
            // 获得最大公倍数
            long lcm = a / gcd(a, b) * b;
            // 右边界为大数*n，类似于ab相等的情况
            long left = 0, right = (long) Math.max(a, b) * n;
            while (left < right) { // 开区间不为空
                long mid = left + (right - left) / 2;
                // 0到mid中的神奇数=0到mid能被a整除的数+0到mid能被b整除的数-能同时被a与b整除的数
                if (mid / a + mid / b - mid / lcm >= n) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return (int) (right % MOD);
        }

        // 辗转相除求最大公约数
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}