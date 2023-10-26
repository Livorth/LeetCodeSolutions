package daily.leetcode.editor.cn;

import java.util.*;

public class Question2520 {
    public static void main(String[] args) {
        Solution solution = new Question2520().new Solution();
        System.out.println(solution.countDigits(121));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.9 MB,击败了78.08% 的Java用户
     */
    class Solution {
        public int countDigits(int num) {
            int res = 0;
            int k = num;
            while (k > 0) {
                int a = k % 10;
                k = k / 10;
                if (num % a == 0) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}