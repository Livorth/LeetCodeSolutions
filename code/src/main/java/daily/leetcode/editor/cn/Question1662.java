package daily.leetcode.editor.cn;

public class Question1662 {
    public static void main(String[] args) {
        Solution solution = new Question1662().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuffer s1 = new StringBuffer();
            StringBuffer s2 = new StringBuffer();
            for (int i = 0; i < word1.length; i++) {
                s1.append(word1[i]);
            }
            for (int i = 0; i < word2.length; i++) {
                s2.append(word2[i]);
            }
            if (new String(s1).equals(new String(s2))) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}