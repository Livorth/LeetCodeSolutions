package daily.leetcode.editor.cn;

import java.util.*;

public class Question761 {
    public static void main(String[] args) {
        Solution solution = new Question761().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String makeLargestSpecial(String s) {
            // count 记录当前子串是否为 特殊的二进制序列
            int count = 0;
            // 记录当前子串的起始位置
            int left = 0;

            List<String> strings = new ArrayList<String>();
            for (int i = 0; i < s.length(); i++) {
                count += s.charAt(i) == '1' ? 1 : -1;
                if(count == 0){
                    // 递归，将当前子串内部的子子串先进行处理
                    strings.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
            // 排序，字典序大的放前
            Collections.sort(strings, (a, b) -> b.compareTo(a));
            StringBuilder ans = new StringBuilder();
            for (String string : strings) {
                ans.append(string);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


