package daily.leetcode.editor.cn;

import java.util.*;

public class Question2678 {
    public static void main(String[] args) {
        Solution solution = new Question2678().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 模拟，太简单了
     * 	执行耗时:1 ms,击败了75.00% 的Java用户
     * 	内存消耗:40.5 MB,击败了23.02% 的Java用户
     */
    class Solution {
        public int countSeniors(String[] details) {
            int res = 0;
            for (String detail : details) {
                String age = detail.substring(11, 13);
                if (Integer.valueOf(age) > 60) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}