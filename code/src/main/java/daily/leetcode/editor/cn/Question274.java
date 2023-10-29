package daily.leetcode.editor.cn;

import java.util.*;

public class Question274 {
    public static void main(String[] args) {
        Solution solution = new Question274().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了30.14% 的Java用户
     */
    public class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            // 计数，用数组也行，用map也行
            int[] count = new int[len + 1];
            for (int i = 0; i < len; i++) {
                // 当引用次数大于n时，统一算做n
                // 因为h指数最多只能到全部的论文
                if (citations[i] >= len) {
                    count[len]++;
                } else {
                    count[citations[i]]++;
                }
            }
            int sum = 0;
            // 从后往前遍历
            for (int i = len; i >= 0; i--) {
                // sum为大于或等于当前引用次数 i 的总论文数
                sum += count[i];
                if (sum >= i) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}