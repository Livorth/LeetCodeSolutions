package daily.leetcode.editor.cn;

import java.util.*;

public class Question26 {
    public static void main(String[] args) {
        Solution solution = new Question26().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果尚未达到n或者遇到非重复元素
            if (nums[i] != nums[index - n]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    public int removeDuplicates1(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}