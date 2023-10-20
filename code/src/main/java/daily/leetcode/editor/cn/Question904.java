package daily.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Question904 {
    public static void main(String[] args) {
        Solution solution = new Question904().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit1(int[] fruits) {
            // 记录在当前窗口中每一种水果的个数
            Map<Integer, Integer> count = new HashMap<>();
            int j = 0, n = fruits.length;
            for (int x : fruits) {
                // x的数量加1
                count.put(x, count.getOrDefault(x, 0) + 1);
                // 当出现第三种水果的时候，需要去掉区间最左边的那种水果
                if (count.size() > 2) {
                    // 这里没有使用循环遍历将左指针一直右移，是因为要求出最大的滑动窗口，可以只扩不缩
                    int y = fruits[j++];
                    count.put(y, count.get(y) - 1);
                    if (count.get(y) == 0) {
                        count.remove(y);
                    }
                }
            }
            return n - j;
        }


        public int totalFruit(int[] fruits) {
            // 记录两个水果的种类
            int ln = fruits[0];
            int rn = fruits[0];
            int res = 0;

            for (int l = 0, r = 0; r < fruits.length; r++) {
                // 出现第三种水果
                if (fruits[r] != ln && fruits[r] != rn) {
                    //更新left，从当前right向前找left位置
                    l = r - 1;
                    while (l > 0 && fruits[l] == fruits[l - 1]) {
                        l--;
                    }
                    // 更新水果的种类
                    ln = fruits[l];
                    rn = fruits[r];
                }
                // 更新窗口的最大值
                int len = r - l + 1;
                res = Math.max(res, len);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}