package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question1691 {
    public static void main(String[] args) {
        Solution solution = new Question1691().new Solution();
        int[][] a = {{50,45,20},{95,37,53},{45,23,12}};
        solution.maxHeight(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeight(int[][] cuboids) {
            for (int[] c : cuboids) Arrays.sort(c);
            Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
            int ans = 0, n = cuboids.length;
            int[] f = new int[n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j){
                    // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                    if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]){
                        f[i] = Math.max(f[i], f[j]); // cuboids[j] 可以堆在 cuboids[i] 上
                    }
                }
                f[i] += cuboids[i][2];
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}