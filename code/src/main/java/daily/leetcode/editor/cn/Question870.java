package swordOffer.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class Question870 {
    public static void main(String[] args) {
        Solution solution = new Question870().new Solution();
        solution.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            // 辅助数组，存储nums2在升序排后的下标位置
            Integer[] nums2index = new Integer[nums2.length];
            for (int i = 0; i < nums2.length; i++) nums2index[i] = i;
            // 对nums2进行升序排序，但是只排辅助数组
            Arrays.sort(nums2index, Comparator.comparingInt(i -> nums2[i]));
            Arrays.sort(nums1);
            // 双指针往中间收拢
            int head = 0, tail = nums1.length - 1;
            for (int i = nums2index.length - 1; i >= 0; i--) {
                // num1的最大值要比num2的最大值大
                if (nums1[tail] > nums2[nums2index[i]]) {
                    nums2[nums2index[i]] = nums1[tail--];
                } else {
                    nums2[nums2index[i]] = nums1[head++]; // 否则，将“当前最小值”赋值给它
                }
            }
            return nums2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}