package daily.leetcode.editor.cn;

import java.util.*;

public class Question667 {
    public static void main(String[] args) {
        Solution solution = new Question667().new Solution();
        solution.constructArray(8,3);
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArray(int n, int k) {
            // 结果数组中只包括1到n
            int[] ans = new int[n];
            // 数组中前k个数字进行交替放置，达到k个不同差每个数出现的次数
            for (int i = 0, low = 1, high = k + 1; i <= k; i++) {
                // 奇数位从1开始递增，偶数位从k+1开始递减
                if ((i & 1) == 0) {
                    ans[i] = low++;
                }
                else {
                    ans[i] = high--;
                }
            }
            // 剩下的递增填充，填充数字差都只有1，而在上面交替的部分已经存在过1
            for (int i = k + 1; i < n; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}