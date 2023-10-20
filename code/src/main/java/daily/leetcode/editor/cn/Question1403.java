package daily.leetcode.editor.cn;

import java.util.*;

public class Question1403 {
    public static void main(String[] args) {
        Solution solution = new Question1403().new Solution();
        int[] nums = {3, 5, 2, 4, 1, 9};
        solution.minSubsequence(nums);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            ArrayList<Integer> ans = new ArrayList<>();
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            int count = 0;
            for (int i = nums.length -1 ; i >= 0; i--) {
                count += nums[i];
                ans.add(nums[i]);
                if(count > sum -count){
                    return ans;
                }
            }
            
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}