package daily.leetcode.editor.cn;

public class Question2134 {
    public static void main(String[] args) {
        Solution solution = new Question2134().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 定长滑动窗口
     * 执行耗时:8 ms,击败了60.76% 的Java用户
     * 内存消耗:57.5 MB,击败了44.94% 的Java用户
     */
    class Solution {
        public int minSwaps(int[] nums) {
            int n = nums.length;
            // 确认滑动窗口长度
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) j++;
            }
            int count = 0;
            for (int i = 0; i < j; i++) {
                if (nums[i] == 1) count++;
            }
            int res = count;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) count--;
                if (nums[(i + j) % n] == 1) count++;
                res = Math.max(res, count);
            }
            return j - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}