package daily.leetcode.editor.cn;

import java.util.HashMap;

public class Question1542 {
    public static void main(String[] args) {
        Solution solution = new Question1542().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 前缀异或和，使用HashMap存储前缀异或值以及其第一次出现的位置
     * 执行耗时:108 ms,击败了45.24% 的Java用户
     * 内存消耗:44.4 MB,击败了33.33% 的Java用户
     */
    class Solution {
        public int longestAwesome(String s) {
            // key:前缀异或值, value:其第一次出现的位置
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int res = 0;
            // 记录前缀异或和的值
            int pre = 0;
            for (int i = 0; i < s.length(); i++) {
                pre = pre ^ (1 << s.charAt(i) - '0');
                // 奇数部分
                for (int j = 0; j < 10; j++) {
                    if (map.containsKey(pre ^ (1 << j))) {
                        res = Math.max(res, i - map.get(pre ^ (1 << j)));
                    }
                }
                // 偶数部分
                if (map.containsKey(pre)) {
                    res = Math.max(res, i - map.get(pre));
                } else {
                    map.put(pre, i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}