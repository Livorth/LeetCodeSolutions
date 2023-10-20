package daily.leetcode.editor.cn;

import java.util.*;

public class Question1470 {
    public static void main(String[] args) {
        Solution solution = new Question1470().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}