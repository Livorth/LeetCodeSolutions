package daily.leetcode.editor.cn;

public class Question343 {
    public static void main(String[] args) {
        Solution solution = new Question343().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int integerBreak(int n) {
            int maxValue = 0;
            // 尽可能确保每段长度相近
            for (int i = 2; i <= n; i++) {
                int y = n % i;
                int x = n / i;
                int currentMax = 1;
                // 尽可能将多出来的部分y分给每个x
                for (int j = 0; j < i; j++) {
                    int z = x;
                    if (y > 0) {
                        z++;
                        y--;
                    }
                    currentMax *= z;
                }
                maxValue = Math.max(maxValue, currentMax);
            }
            return maxValue;
        }
    }

    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int sum = 1;
            while (n > 4) {
                sum *= 3;
                n -= 3;
            }
            sum *= n;
            return sum;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}