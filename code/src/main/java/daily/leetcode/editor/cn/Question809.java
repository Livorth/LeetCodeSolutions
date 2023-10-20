package daily.leetcode.editor.cn;

public class Question809 {
    public static void main(String[] args) {
        Solution solution = new Question809().new Solution();
        String[] words = new String[]{"hello"};
        solution.expressiveWords("heeellooo", words);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int ans = 0;
            for (String word : words) {
                if (isRealFeel(s, word)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isRealFeel(String main_, String str_) {
            char[] main = main_.toCharArray();
            char[] str = str_.toCharArray();
            if (main.length < str.length) return false;
            int index = 0;
            int rightM = 0, rightS = 0;
            while (rightM < main.length && rightS < str.length) {
                int countM = 0, countS = 0;
                while (rightM < main.length && main[index] == main[rightM]) {
                    countM++;
                    rightM++;
                }

                while (rightS < str.length && main[index] == str[rightS]) {
                    countS++;
                    rightS++;
                }
                if ((countM != countS && countM < 3) || (countM < countS && countM >= 3)) {
                    return false;
                }
                index = rightM;
            }
            return rightM == main.length && rightS == str.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}