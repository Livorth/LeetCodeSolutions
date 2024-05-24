package daily.leetcode.editor.cn;

public class Question1673 {
    public static void main(String[] args) {
        Solution solution = new Question1673().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单调栈
     * 执行耗时:7 ms,击败了94.69% 的Java用户
     * 内存消耗:59.4 MB,击败了53.98% 的Java用户
     */
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            int[] stack = new int[k];
            int top = 0;
            for (int i = 0; i < nums.length; i++) {
                while (top > 0 && nums[i] < stack[top - 1] && n - i + top > k) {
                    top--;
                }
                if (top < k) {
                    stack[top++] = nums[i];
                }
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}