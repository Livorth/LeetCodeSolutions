package daily.leetcode.editor.cn;

import java.util.*;

public class Question1832 {
    public static void main(String[] args) {
        Solution solution = new Question1832().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfPangram(String sentence) {
            boolean[] count = new boolean[26];
            for (char ch : sentence.toCharArray()) {
                count[ch - 'a'] = true;
            }
            for (boolean b : count) {
                if(!b) return false;
            }
            return true;
        }
        public boolean checkIfPangram1(String sentence) {
            int count = 0;
            for (char ch : sentence.toCharArray()) {
                count |= 1 << (ch - 'a');
            }
            return count == (1 << 26) - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}