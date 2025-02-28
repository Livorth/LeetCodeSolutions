package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {
    public static void main(String[] args) {
        Solution solution = new Question17().new Solution();
        solution.letterCombinations("23");

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:5 ms,击败了12.97% 的Java用户
     * 内存消耗:41.6 MB,击败了5.01% 的Java用户
     */
    class Solution {
        public List<String> letterCombinations(String digits) {
            char[] chars = digits.toCharArray();
            List<String> result = new ArrayList<>();
            if (chars.length == 0) return result;
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    String s = map.get(chars[i]);
                    char[] charArray = s.toCharArray();
                    if (i == 0) {
                        for (char c : charArray) {
                            result.add(String.valueOf(c));
                        }
                    } else {
                        List<String> temp = new ArrayList<>();
                        for (int j = 0; j < s.length(); j++) {
                            for (String str : result) {
                                temp.add(str + charArray[j]);
                            }
                        }
                        result = temp;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}