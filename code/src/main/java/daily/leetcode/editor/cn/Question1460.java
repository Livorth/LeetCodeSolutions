package daily.leetcode.editor.cn;

import java.util.*;

public class Question1460 {
    public static void main(String[] args) {
        Solution solution = new Question1460().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] counts = new int[1005];
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                // 多于0的时候进行一次计数
                if (++counts[target[i]] == 1) {
                    count++;
                }
                // 少于1的时候进行一次计数
                if (--counts[arr[i]] == 0) {
                    count--;
                }
            }
            // 所有数字都归零
            return count == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}