package daily.leetcode.editor.cn;

import java.util.*;

public class Question2558 {
    public static void main(String[] args) {
        Solution solution = new Question2558().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:6 ms,击败了55.67% 的Java用户
     * 内存消耗:40.2 MB,击败了52.71% 的Java用户
     */
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
                return b.compareTo(a);
            });
            long res = 0;
            for (int gift : gifts) {
                queue.add(gift);
            }
            while (!queue.isEmpty() && k-- > 0) {
                Integer poll = queue.poll();
                int sqrt = (int) Math.floor(Math.sqrt(poll));
                queue.add(sqrt);
            }
            while (!queue.isEmpty()) {
                res += queue.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}