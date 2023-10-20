package daily.leetcode.editor.cn;

public class Question856 {
    public static void main(String[] args) {
        Solution solution = new Question856().new Solution();
        solution.scoreOfParentheses("(((())))");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            int[] stack = new int[s.length()];
            int top = 0;
            stack[top++] = 0;
            for (int i = 0; i < s.length(); i++) {
                // 左括号直接入栈
                if (s.charAt(i) == '(') {
                    stack[top++] = 0;
                } else {
                    // 将栈顶元素出栈
                    int k = stack[--top];
                    // 如果栈顶是左括号，则值为1，如果为值，则需要乘以2
                    stack[top - 1] += k == 0 ? 1 : k * 2;
                }
            }
            return stack[top - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
