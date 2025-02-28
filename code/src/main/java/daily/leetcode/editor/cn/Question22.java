package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public static void main(String[] args) {
        Solution solution = new Question22().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:2 ms,击败了40.15% 的Java用户
     * 内存消耗:42.6 MB,击败了15.67% 的Java用户
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(n, n, "", res);
            return res;
        }

        private void dfs(int left, int right, String path, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(path);
                return;
            }
            if (left > 0) {
                dfs(left - 1, right, path + "(", res);
            }
            if (right > left) {
                dfs(left, right - 1, path + ")", res);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}