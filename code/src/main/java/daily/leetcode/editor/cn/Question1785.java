package daily.leetcode.editor.cn;

public class Question1785 {
    public static void main(String[] args) {
        Solution solution = new Question1785().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum == goal) return 0;
            sum = Math.abs(sum - goal);

            int ans = (int) (sum / limit) + (sum % limit != 0 ? 1 : 0);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}