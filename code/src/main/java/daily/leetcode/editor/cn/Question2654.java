package daily.leetcode.editor.cn;

public class Question2654 {
    public static void main(String[] args) {
        Solution solution = new Question2654().new Solution();

        solution.minOperations(new int[]{2, 6, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双重循环求gcd为1的最短连续子数组
     * 执行耗时:2 ms,击败了25.00% 的Java用户
     * 内存消耗:41 MB,击败了72.73% 的Java用户
     */
    class Solution {
        public int minOperations(int[] nums) {
            int g = nums[0];
            int count = 0;
            for (int num : nums) {
                g = gcd(g, num);
                if (num == 1) count++;
            }
            // 数组变不了1的
            if (g != 1) return -1;
            // 数组中已经有1的
            if (count != 0) return nums.length - count;

            // 找到gcd为1的最短连续子数组
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int gcd = nums[i];
                for (int j = i; j < nums.length; j++) {
                    gcd = gcd(gcd, nums[j]);
                    if (gcd == 1) {
                        res = Math.min(res, j - i + 1);
                    }
                }
            }
            return nums.length + res - 2;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}