package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question11 {
    public static void main(String[] args) {
        Solution solution = new Question11().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = (r - l) * Math.min(height[l], height[r]);
                int minH = Math.min(height[l], height[r]);
                ans = Math.max(ans, area);
                // 一次性跳过多个短板
                while (height[l] <= minH && l < r) {
                    l++;
                }
                while (height[r] <= minH && l < r) {
                    r--;
                }
            }
            return ans;
        }

        public int maxArea1(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            // 实在是优雅
            while (i < j) {
                res = height[i] < height[j] ?
                        Math.max(res, (j - i) * height[i++]) :
                        Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}