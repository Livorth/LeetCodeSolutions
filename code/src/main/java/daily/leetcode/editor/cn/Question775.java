package daily.leetcode.editor.cn;

public class Question775 {
    public static void main(String[] args) {
        Solution solution = new Question775().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - i > 1 || nums[i] - i < -1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}