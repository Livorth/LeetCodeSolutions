package daily.leetcode.editor.cn;

public class Question791 {
    public static void main(String[] args) {
        Solution solution = new Question791().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : order.toCharArray()) {
                while (count[c - 'a']-- > 0) {
                    stringBuilder.append(c);
                }
            }
            for (int i = 0; i < 26; i++) {
                while (count[i]-- > 0) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}