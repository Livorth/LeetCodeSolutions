package daily.leetcode.editor.cn;

import java.util.*;

public class Question1410 {
    public static void main(String[] args) {
        Solution solution = new Question1410().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:28 ms,击败了61.86% 的Java用户
     * 内存消耗:43.3 MB,击败了46.61% 的Java用户
     */
    class Solution {
        public String entityParser(String text) {
            return text.replace("&quot;", "\"")
                    .replace("&apos;", "'")
                    .replace("&gt;", ">")
                    .replace("&lt;", "<")
                    .replace("&frasl;", "/")
                    .replace("&amp;", "&");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}