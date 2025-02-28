package daily.leetcode.editor.cn;

public class Question762 {
    public static void main(String[] args) {
//        Solution solution = new Question762().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:5 ms,击败了67.69% 的Java用户
     * 内存消耗:39.4 MB,击败了88.44% 的Java用户
     */
    static class Solution {
        static boolean[] hash = new boolean[40];

        static {
            int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            for (int x : nums) hash[x] = true;
        }

        public int countPrimeSetBits(int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                int x = i, cnt = 0;
                while (x != 0 && ++cnt >= 0) x -= (x & -x);
                if (hash[cnt]) ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}