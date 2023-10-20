package daily.leetcode.editor.cn;

public class Question1812 {
    public static void main(String[] args) {
        Solution solution = new Question1812().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean squareIsWhite(String coordinates) {
            int cha = coordinates.charAt(0) - 'a';
            int num = coordinates.charAt(1) - '1';

            return (cha + num) % 2 != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}