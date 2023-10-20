package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question1636 {
    public static void main(String[] args) {
        Solution solution = new Question1636().new Solution();
        int[] ints = {1, 1, 2, 2, 2, 3};
        solution.frequencySort(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            int[][] count = new int[205][2];

            for (int i = 0; i < nums.length; i++) {
                count[nums[i] + 101][0] = nums[i];
                count[nums[i] + 101][1]++;
            }
            Arrays.sort(count, (a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
            int index = nums.length - 1;
            for (int i = 0; i < count.length; i++) {
                if(count[i][1] == 0) break;
                while(count[i][1]-- != 0){
                    nums[index--] = count[i][0];
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}