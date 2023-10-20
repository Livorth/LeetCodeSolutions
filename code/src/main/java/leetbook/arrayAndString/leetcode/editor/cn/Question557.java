package leetbook.arrayAndString.leetcode.editor.cn;

public class Question557 {
    public static void main(String[] args) {
        Solution solution = new Question557().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public String reverseWords(String s) {
//            StringBuffer string = new StringBuffer(s);
//            // 快慢指针去空格
//            int slow = 0;
//            for (int i = 0; i < string.length(); i++) {
//                if (string.charAt(i) != ' ') {
//                    // 手动添加空格
//                    if (slow != 0) string.setCharAt(slow++, ' ');
//                    int start = slow;
//                    while (i < string.length() && string.charAt(i) != ' ') {
//                        string.setCharAt(slow++, string.charAt(i++));
//                    }
//                    // 对单个单词进行翻转
//                    flipString(string, start, slow);
//                }
//            }
//            return string.substring(0, slow);
//
//        }
//
//        private StringBuffer flipString(StringBuffer string, int start, int end) {
//            for (int i = 0; i < (end - start + 1) / 2; i++) {
//                char tmp = string.charAt(start + i);
//                string.setCharAt(start + i, string.charAt(end - i - 1));
//                string.setCharAt(end - i - 1, tmp);
//            }
//            return string;
//        }
//    }
    class Solution {
        public String reverseWords(String s) {
            char[] pre = s.toCharArray();
            // 双指针找到当前单词的那个字符串
            int i = 0, j = 0;
            for (char c : pre) {
                if (c == ' ') {
                    flipString(pre, i, j - 1);
                    i = j + 1;
                }
                j++;
            }
            flipString(pre, i, j - 1);
            return new String(pre);
        }

        private void flipString(char[] pre, int i, int j) {
            char tmp;
            while (i < j) {
                tmp = pre[i];
                pre[i++] = pre[j];
                pre[j--] = tmp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

