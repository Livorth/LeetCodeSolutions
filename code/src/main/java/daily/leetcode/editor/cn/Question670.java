package daily.leetcode.editor.cn;

import java.util.*;

public class Question670 {
    public static void main(String[] args) {
        Solution solution = new Question670().new Solution();
        solution.maximumSwap(2736);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            // 从后往前遍历，寻找每个数他后面比他大的数最远下标
            int[] moreBig = new int[chars.length];
            // 最大的数的值，与其下标
            int max = chars[chars.length - 1] - '0';
            int local = chars.length - 1;
            moreBig[chars.length - 1] = -1;
            for (int i = chars.length - 2; i >= 0; i--) {
                if (chars[i] - '0' < max) {
                    moreBig[i] = local;
                }
                // 更大则替换
                else if (chars[i] - '0' > max) {
                    max = chars[i] - '0';
                    local = i;
                    moreBig[i] = -1;
                } else {
                    moreBig[i] = -1;
                }
            }
            // 从前往后遍历找到一定能被替换的数
            for (int i = 0; i < chars.length; i++) {
                if (moreBig[i] != -1) {
                    // 交换
                    char c = chars[moreBig[i]];
                    chars[moreBig[i]] = chars[i];
                    chars[i] = c;
                    break;
                }
            }
            return Integer.valueOf(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}