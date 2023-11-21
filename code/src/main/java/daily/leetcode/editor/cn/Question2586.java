package daily.leetcode.editor.cn;

import java.util.*;

public class Question2586 {
    public static void main(String[] args) {
        Solution solution = new Question2586().new Solution();
        solution.vowelStrings(new String[]{"are","amy","u"}, 0, 2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            HashSet<Character> set = new HashSet();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');

            int res = 0;
            for (int i = left; i <= right; i++) {
                char c1 = words[i].charAt(0);
                char c2 = words[i].charAt(words[i].length() - 1);
                if (set.contains(c1) && set.contains(c2)) {
                    res++;
                }
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}