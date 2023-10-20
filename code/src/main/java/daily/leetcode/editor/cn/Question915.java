package daily.leetcode.editor.cn;

public class Question915 {
    public static void main(String[] args) {
        Solution solution = new Question915().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int leftMax = nums[0];
            int maxNum = nums[0];
            int bound = 0;
            for (int i = 1; i < n; ++i) {
                // 右侧的值比左侧值的最大值更小，需要放到left里
                if (nums[i] < leftMax) {
                    leftMax = maxNum;
                    bound = i;
                } else {
                    // 更新最大值
                    maxNum = Math.max(maxNum, nums[i]);
                }
            }
            return bound + 1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}