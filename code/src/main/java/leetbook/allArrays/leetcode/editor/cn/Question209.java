package leetbook.allArrays.leetcode.editor.cn;

public class Question209 {
    public static void main(String[] args) {
        Solution solution = new Question209().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
            while (right < nums.length) {
                // 先在右侧累加
                sum += nums[right++];
                // 将左侧尽可能减少
                while (sum >= s) {
                    min = Math.min(min, right - left);
                    sum -= nums[left++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}