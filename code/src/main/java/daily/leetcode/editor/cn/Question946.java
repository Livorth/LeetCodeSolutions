package daily.leetcode.editor.cn;

import java.util.*;

public class Question946 {
    public static void main(String[] args) {
        Solution solution = new Question946().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int n = pushed.length;
            int top = 0;
            for (int i = 0, j = 0; i < n; i++) {
                // 先入栈
                pushed[top++] = pushed[i];
                // 再出栈
                while (top > 0 && pushed[top - 1] == popped[j] ) {
                    j++;
                    top--;
                }
            }
            // 最终所有元素都要出栈
            return top == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}