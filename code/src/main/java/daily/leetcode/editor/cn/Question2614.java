package daily.leetcode.editor.cn;

public class Question2614 {
    public static void main(String[] args) {
        Solution solution = new Question2614().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:4 ms,击败了59.22% 的Java用户
     * 内存消耗:57.7 MB,击败了43.21% 的Java用户
     */
    class Solution {
        public int diagonalPrime(int[][] nums) {
            int length = nums.length;
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (isPrime(nums[i][i])) {
                    max = Math.max(max, nums[i][i]);
                }
                if (isPrime(nums[i][length - i - 1])) {
                    max = Math.max(max, nums[i][length - i - 1]);
                }
            }
            return max;
        }

        private boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return n >= 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}