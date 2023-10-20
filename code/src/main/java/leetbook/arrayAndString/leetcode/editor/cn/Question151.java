package leetbook.arrayAndString.leetcode.editor.cn;

public class Question151 {
    public static void main(String[] args) {
        Solution solution = new Question151().new Solution();
        String the_sky_is_blue = solution.reverseWords("hello world  ");
        System.out.println(the_sky_is_blue);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 	执行耗时:3 ms,击败了89.10% 的Java用户
         * 	内存消耗:41.2 MB,击败了73.84% 的Java用户
         */
        public String reverseWords(String s) {
            // 加个空格做哨兵，标志着第一个单词的结束
            s = ' ' + s;
            int n = s.length();
            // 辅助数组
            StringBuilder ans = new StringBuilder();
            for (int left = n - 1, right = n; left >= 0; left--) {
                char ch = s.charAt(left);
                // 遇到空格就是一个新单词
                if (ch == ' ') {
                    // 将这一段截到ans中去，同时避免两个连续的空格
                    if (left + 1 < right) {
                        ans.append(s, left + 1, right).append(' ');
                    }
                    right = left;
                }
            }
            return ans.substring(0, ans.length() - 1);
        }

        /**
         * 	执行耗时:12 ms,击败了6.90% 的Java用户
         * 	内存消耗:41.3 MB,击败了63.10% 的Java用户
         */
        public String reverseWords1(String s) {
            StringBuffer string = new StringBuffer(s);
            // 对整个字符串进行翻转
            flipString(string, 0, string.length());
            // 快慢指针去空格
            int slow = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != ' ') {
                    // 手动添加空格
                    if (slow != 0) string.setCharAt(slow++, ' ');
                    int start = slow;
                    while (i < string.length() && string.charAt(i) != ' ') {
                        string.setCharAt(slow++, string.charAt(i++));
                    }
                    // 对单个单词进行翻转
                    flipString(string, start, slow);
                }
            }
            return string.substring(0, slow);

        }

        private StringBuffer flipString(StringBuffer string, int start, int end) {
            for (int i = 0; i < (end - start + 1) / 2; i++) {
                char tmp = string.charAt(start + i);
                string.setCharAt(start + i, string.charAt(end - i - 1));
                string.setCharAt(end - i - 1, tmp);
            }
            return string;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
