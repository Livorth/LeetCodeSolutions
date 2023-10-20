package daily.leetcode.editor.cn;

import java.util.*;

public class Question754 {
    public static void main(String[] args) {
        Solution solution = new Question754().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int s = 0, n = 0;
            while (s < target || (s - target) % 2 == 1) // 没有到达（越过）终点，或者相距奇数
                s += ++n;
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}