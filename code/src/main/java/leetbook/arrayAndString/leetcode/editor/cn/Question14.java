package leetbook.arrayAndString.leetcode.editor.cn;

public class Question14 {
    public static void main(String[] args) {
        Solution solution = new Question14().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String ans = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int index = 0;
                // 求出ans与strs[i]的最长公共前缀
                while (index < ans.length() && index < strs[i].length()) {
                    if (ans.charAt(index) != strs[i].charAt(index)) break;
                    index++;
                }
                // index为0则说明无前缀，如果不为0则更新ans
                if (index == 0) return "";
                ans = ans.substring(0, index);

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}