package daily.leetcode.editor.cn;

public class Question1704 {
    public static void main(String[] args) {
        Solution solution = new Question1704().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 计算出元音个数
        int parse(String s) {
            // int[] tabs = new int[5];
            int res = 0;
            for (char c : s.toCharArray()) {
                int p = "aeiouAEIOU".indexOf(c);
                if (p != -1) {
                    res++;
                }
            }
            return res;
        }

        public boolean halvesAreAlike(String s) {

            int n = s.length();
            String s1 = s.substring(0, n / 2);
            String s2 = s.substring(n / 2);

            int r1 = parse(s1);
            int r2 = parse(s2);
            return r1 == r2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}