package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question16 {
    public static void main(String[] args) {
        Solution solution = new Question16().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:12 ms,击败了73.22% 的Java用户
     * 内存消耗:42.4 MB,击败了22.06% 的Java用户
     */
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}