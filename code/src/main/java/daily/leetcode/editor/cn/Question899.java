package daily.leetcode.editor.cn;

import java.util.*;

public class Question899 {
    public static void main(String[] args) {
        Solution solution = new Question899().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String orderlyQueue(String s, int k) {
            if(k == 1) {
                String ans = s;
                for (int i = 1; i < s.length(); i++) {
                    // 重新拼接
                    String newStr = s.substring(i) + s.substring(0, i);
                    if (newStr.compareTo(ans) < 0) {
                        ans = newStr;
                    }
                }
                return ans;
            }
            // 只要k大于1，那么就一定能让序列有序
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

