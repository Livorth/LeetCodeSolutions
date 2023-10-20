package daily.leetcode.editor.cn;

public class Question1732 {
    public static void main(String[] args) {
        Solution solution = new Question1732().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestAltitude(int[] g) {
            int cur = 0, ans = 0;
            for (int x : g) {
                cur += x;
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}