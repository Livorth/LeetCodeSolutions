package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question26 {
    public static void main(String[] args) {
        Solution solution = new Question26().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null) return 0;
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] != nums[i - 1]){
                    nums[count++] = nums[i];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}