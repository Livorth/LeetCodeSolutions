package daily.leetcode.editor.cn;

import java.util.*;

public class Question1450 {
    public static void main(String[] args) {
        Solution solution = new Question1450().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 常规模拟
        public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
            int n = startTime.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                    ans++;
                }
            }
            return ans;
        }
        // 差分前缀和
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int[] count = new int[1005];
            // 计算差分数组
            for (int i = 0; i < startTime.length; i++) {
                count[startTime[i]]++;
                count[endTime[i] + 1]--;
            }
            int ans = 0;
            // 前缀和统计次数
            for (int i = 0; i <= queryTime; i++) {
                ans += count[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}