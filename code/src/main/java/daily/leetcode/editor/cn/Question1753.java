package daily.leetcode.editor.cn;

public class Question1753 {
    public static void main(String[] args) {
        Solution solution = new Question1753().new Solution();
        int i = solution.maximumScore(1, 8, 8);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int a, int b, int c) {
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int mid = a + b + c - max - min;
            if (min == 0 && mid == 0) return 0;
            return 1 + maximumScore(max - 1, mid - 1, min);
        }

        public int maximumScore1(int a, int b, int c) {
            // 最大值和除去最大值剩下的两个数
            int max = Math.max(Math.max(a, b), c), ab = a + b + c - max;
            // 如果剩下的两个数据小于最大数，那么剩下两数都会被取完
            // 反之，那么剩下的部分就只会是(0,0,1)和(0,0,0)的情况，直接求和除以2即可
            return ab < max ? ab : (a + b + c) / 2;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}