package daily.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Question1805 {
    public static void main(String[] args) {
        Solution solution = new Question1805().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int numDifferentIntegers(String word) {
            HashSet<String> set = new HashSet<>();
            int left = 0;
            while (left < word.length()) {
                // 去除前边的非数字字符
                while (left < word.length() && !Character.isDigit(word.charAt(left))) {
                    left++;
                }
                // 找到右边界
                int right = left;
                while (right < word.length() && Character.isDigit(word.charAt(right))) {
                    right++;
                }
                // 去除前缀0
                while (left < right && word.charAt(left) == '0') {
                    left++;
                }
                // 加入hash
                set.add(word.substring(left, right));
                left = right;
            }
            return set.size();
        }
    }

    class Solution {
        public int numDifferentIntegers(String word) {
            int n = word.length();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!Character.isDigit(word.charAt(i))) continue;
                if (i < n && word.charAt(i) == '0') {
                    // 去除前缀0
                    while (i < n && word.charAt(i) == '0') i++;
                    // 针对只有0的情况下进行特殊处理
                    if ((i < n && !Character.isDigit(word.charAt(i)) && word.charAt(i - 1) == '0') || i == n) {
                        set.add("0");
                    }
                }
                int l = i;
                // 找到数字的右边界
                while (i < n && Character.isDigit(word.charAt(i))) i++;
                if (i > l) set.add(word.substring(l, i));
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}