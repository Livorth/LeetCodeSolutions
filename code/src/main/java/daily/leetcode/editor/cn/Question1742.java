package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question1742 {
    public static void main(String[] args) {
        Solution solution = new Question1742().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] count = new int[50];
            int max = -1;
            for (int i = lowLimit; i <= highLimit; ++i) {
                int y = 0;
                // 计算每一位的和
                for (int x = i; x > 0; x /= 10) {
                    y += x % 10;
                }
                ++count[y];
                max = Math.max(max, count[y]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}