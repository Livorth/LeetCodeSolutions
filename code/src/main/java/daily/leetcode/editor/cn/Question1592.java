package daily.leetcode.editor.cn;

import java.util.*;

public class Question1592 {
    public static void main(String[] args) {
        Solution solution = new Question1592().new Solution();
        solution.reorderSpaces("  this   is  a sentence ");
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorderSpaces(String text) {
            // 统计出空格数量和单词数量
            int spaces = 0, words = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    spaces++;
                }
                else if (i - 1 < 0 || text.charAt(i - 1) == ' ') {
                    words++;
                }
            }

            // 计算平均空格数，注意单词为一个的时候的边界值处理
            int average = words - 1 == 0 ? 0 : spaces / (words - 1);

            // 构造结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != ' ') {
                    sb.append(text.charAt(i));

                    // 如果后面一个为空格，说明本单词结束，放置中间的空格
                    if (i + 1 < text.length() && text.charAt(i + 1) == ' ' && --words > 0) {
                        for (int j = 0; j < average; j++) {
                            sb.append(' ');
                            spaces--;
                        }
                    }
                }
            }

            // 剩余空格的处理
            while (spaces-- > 0) {
                sb.append(' ');
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



