package daily.leetcode.editor.cn;

import java.util.*;

public class Question2525 {
    public static void main(String[] args) {
        Solution solution = new Question2525().new Solution();
        solution.categorizeBox(2909, 3968, 3272, 727);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            boolean bulky = false;
            boolean heavy = false;
            if (length >= 10000 || width >= 10000 || height >= 10000 || mass >= 10000) bulky = true;
            // 注意转为long
            if (1L * length * width * height >= 1000000000L) bulky = true;
            if (mass >= 100) heavy = true;
            if (bulky && heavy) return "Both";
            if (!bulky && heavy) return "Heavy";
            if (bulky && !heavy) return "Bulky";
            return "Neither";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}