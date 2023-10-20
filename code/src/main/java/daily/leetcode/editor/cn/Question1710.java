package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question1710 {
    public static void main(String[] args) {
        Solution solution = new Question1710().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> {
                return b[1] - a[1];
            });

            int ans = 0;
            for (int[] boxType : boxTypes) {
                if (truckSize >= boxType[0]) {
                    ans += boxType[0] * boxType[1];
                    truckSize -= boxType[0];
                } else {
                    ans += truckSize * boxType[1];
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}