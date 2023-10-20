package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question75 {
    public static void main(String[] args) {
        Solution solution = new Question75().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors1(int[] nums) {
            int countZero = 0;
            int countOne = 0;
            int countBlue = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) countZero++;
                if (nums[i] == 1) countOne++;
                if (nums[i] == 2) countBlue++;
            }
            int count = 0;
            while (countZero-- != 0) {
                nums[count++] = 0;
            }
            while (countOne-- != 0) {
                nums[count++] = 1;
            }
            while (countBlue-- != 0) {
                nums[count++] = 2;
            }
        }

        public void sortColors(int[] nums) {
            // 0的范围从前往后，2的范围从后往前，[0,zero]为全0，[two,n]为全2
            int zero = -1;
            int two = nums.length;
            int i = 0;
            while (i < two) {
                if (nums[i] == 0) {
                    swap(nums, zero++ + 1, i++);
                }
                else if (nums[i] == 2) {
                    // 这里不用i++是因为你不知道从后面换来的是0还是1还是2
                    swap(nums, two-- - 1, i);
                }
                else {
                    i++;
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}