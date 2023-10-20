package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question27 {
    public static void main(String[] args) {
        Solution solution = new Question27().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}