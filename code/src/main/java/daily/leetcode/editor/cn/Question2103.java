package daily.leetcode.editor.cn;

import java.util.*;

public class Question2103 {
    public static void main(String[] args) {
        Solution solution = new Question2103().new Solution();
        solution.countPoints("B0B6G0R6R0R6G9");

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:1 ms,击败了57.52% 的Java用户
     * 内存消耗:39.7 MB,击败了7.84% 的Java用户
     */
    class Solution {
        public int countPoints(String rings) {
            Map<Character, Set<Character>> poles = new HashMap();
            char[] chars = rings.toCharArray();
            for (int i = 0; i < chars.length; i = i + 2) {
                Set<Character> pole = poles.getOrDefault(chars[i + 1], new HashSet<>());
                pole.add(chars[i]);
                poles.put(chars[i + 1], pole);
            }
            int res = 0;
            for (Set<Character> value : poles.values()) {
                if (value.size() == 3) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}