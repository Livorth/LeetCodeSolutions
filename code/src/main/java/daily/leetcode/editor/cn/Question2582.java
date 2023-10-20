package daily.leetcode.editor.cn;

import java.util.*;

public class Question2582 {
    public static void main(String[] args) {
        Solution solution = new Question2582().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int passThePillow(int n, int time) {
            int count = time / (n - 1);
            if (count % 2 == 0) {
                return time % (n - 1) + 1;
            } else {
                return n - time % (n - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}