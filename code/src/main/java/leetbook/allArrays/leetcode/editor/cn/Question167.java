package daily.leetcode.editor.cn;

import java.util.*;

public class Question167 {
    public static void main(String[] args) {
        Solution solution = new Question167().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum1(int[] numbers, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                // 如果map中已经存在
                if (map.containsKey(numbers[i])) {
                    return new int[]{map.get(numbers[i]) + 1, i + 1};
                }

                int t = target - numbers[i];
                map.put(t, i);

            }
            return new int[]{0, 0};
        }

        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (i < j) {
                int sum = numbers[i] + numbers[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
