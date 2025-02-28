package daily.leetcode.editor.cn;

public class Question3115 {
    public static void main(String[] args) {
        Solution solution = new Question3115().new Solution();
        boolean prime = solution.isPrime(4);
        System.out.println(prime);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:5 ms,击败了46.23% 的Java用户
     * 内存消耗:77.5 MB,击败了71.18% 的Java用户
     */
    class Solution {
        // 判断质数
        public boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return n >= 2;
        }

        public int maximumPrimeDifference(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (isPrime(nums[i])) {
                    break;
                }
                i++;
            }
            int j = nums.length - 1;
            while (j >= 0) {
                if (isPrime(nums[j])) {
                    break;
                }
                j--;
            }
            System.out.println(i);
            System.out.println(j);
            return j - i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}