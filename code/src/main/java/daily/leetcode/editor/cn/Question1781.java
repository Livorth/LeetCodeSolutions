package daily.leetcode.editor.cn;

import java.util.*;

public class Question1781 {
    public static void main(String[] args) {
        Solution solution = new Question1781().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int ans = 0;
            // 确定子数组的起始位置
            for (int i = 0; i < s.length(); i++) {
                // 统计每个子数组的字母出现情况
                int[] counts = new int[26];
                int maxCount = 0;
                // 确定子数组的结束位置
                for (int j = i; j < s.length(); j++) {
                    counts[s.charAt(j) - 'a']++;
                    maxCount = Math.max(maxCount, counts[s.charAt(j) - 'a']);
                    int minCount = s.length();
                    // 寻找出现次数最少的字母
                    for (int k = 0; k < 26; k++) {
                        if (counts[k] > 0) {
                            minCount = Math.min(minCount, counts[k]);
                        }
                    }
                    // 计算出结果
                    ans += maxCount - minCount;
                }
            }
            return ans;
        }
    }

//    class Solution {
//        public int beautySum(String s) {
//            int res = 0;
//            for (int i = 0; i < s.length(); i++) {
//                int[] cnt = new int[26];
//                int maxFreq = 0;
//                for (int j = i; j < s.length(); j++) {
//                    cnt[s.charAt(j) - 'a']++;
//                    maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
//                    int minFreq = s.length();
//                    for (int k = 0; k < 26; k++) {
//                        if (cnt[k] > 0) {
//                            minFreq = Math.min(minFreq, cnt[k]);
//                        }
//                    }
//                    res += maxFreq - minFreq;
//                }
//            }
//            return res;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}