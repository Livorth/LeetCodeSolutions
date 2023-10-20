package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question283 {
    public static void main(String[] args) {
        Solution solution = new Question283().new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);

        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}