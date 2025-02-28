package daily.leetcode.editor.cn;

public class Question3101 {
    public static void main(String[] args) {
        Solution solution = new Question3101().new Solution();
        solution.countAlternatingSubarrays(new int[]{0, 1, 1, 1});

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:55.4 MB,击败了23.67% 的Java用户
     */
    class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            long res = 0;
            int l = nums.length;
            int count = 0;
            for (int i = 0; i < l; i++) {
                if (i - 1 >= 0 && nums[i] + nums[i - 1] == 1) {
                    count++;
                } else {
                    count = 1;
                }
                res += count;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}