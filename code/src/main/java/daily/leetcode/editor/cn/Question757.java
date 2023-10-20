package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question757 {
    public static void main(String[] args) {
        Solution solution = new Question757().new Solution();
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int i = solution.intersectionSizeTwo(intervals);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            // 排序，对齐区间的右端点
            Arrays.sort(intervals, (a, b)-> {
                if(a[1] != b[1]){
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });
            // a为s中现有的次大点，b为s中的最大点
            int a = -1, b = -1, ans = 0;
            for (int[] i : intervals) {
                // 1. s与新区间完全没交点：区间的左端点比b还大，需要两个新点加入s
                if (i[0] > b) {
                    a = i[1] - 1; b = i[1];
                    ans += 2;
                }
                // 2. s与新区间只有一个交点：区间的左端点仅比a大，保留b，只需要一个新点加入s
                else if (i[0] > a) {
                    a = b; b = i[1];
                    ans++;
                }
                // 3. s与新区间有两个及以上的交点：区间的右端点等于b，那么不需要新点加入
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}